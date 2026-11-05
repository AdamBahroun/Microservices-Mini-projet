package com.adam.voituremicroservice.service;

import com.adam.voituremicroservice.dto.APIResponseDto;
import com.adam.voituremicroservice.dto.MarqueDto;
import com.adam.voituremicroservice.dto.VoitureMessageDto;
import com.adam.voituremicroservice.dto.VoitureDto;
import com.adam.voituremicroservice.entities.Voiture;
import com.adam.voituremicroservice.exceptions.ResourceNotFoundException;
import com.adam.voituremicroservice.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class VoitureServiceImpl implements VoitureService {

    private VoitureRepository voitureRepository;
    private APIClient apiClient;
    private StreamBridge streamBridge;

    @Override
    public APIResponseDto getVoitureById(Long id) {
        Voiture v = voitureRepository.findById(id).get();

        MarqueDto marqueDto = apiClient.getMarqueByCode(v.getMarqueCode());

        if (marqueDto == null) {
            marqueDto = new MarqueDto();
            marqueDto.setMarqueCode(v.getMarqueCode());
            marqueDto.setNom("NOT AVAILABLE");
        }

        VoitureDto voitureDto = new VoitureDto(
                v.getId(),
                v.getVoitName(),
                v.getVoitCode(),
                v.getMarqueCode(),
                v.getEmail(),
                v.getMobileNumber(),
                v.getCommunicationDone()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setVoitureDto(voitureDto);
        apiResponseDto.setMarqueDto(marqueDto);
        return apiResponseDto;
    }

    @Override
    public VoitureDto createVoiture(VoitureDto voitureDto) {
        Voiture voiture = Voiture.builder()
                .voitName(voitureDto.getVoitName())
                .voitCode(voitureDto.getVoitCode())
                .marqueCode(voitureDto.getMarqueCode())
                .email(voitureDto.getEmail())
                .mobileNumber(voitureDto.getMobileNumber())
                .communicationDone(false)
                .build();

        Voiture savedVoiture = voitureRepository.save(voiture);
        VoitureMessageDto message = new VoitureMessageDto(
                savedVoiture.getId(),
                savedVoiture.getEmail(),
                savedVoiture.getMobileNumber()
        );

        log.info("Sending Communication request for the details: {}", message);
        boolean sent = streamBridge.send("sendCommunication-out-0", message);
        log.info("Is the Communication request successfully triggered ? : {}", sent);

        return new VoitureDto(
                savedVoiture.getId(),
                savedVoiture.getVoitName(),
                savedVoiture.getVoitCode(),
                savedVoiture.getMarqueCode(),
                savedVoiture.getEmail(),
                savedVoiture.getMobileNumber(),
                savedVoiture.getCommunicationDone()
        );
    }

    @Override
    public boolean updateCommunicationStatus(Long voitureId) {
        Voiture voiture = voitureRepository.findById(voitureId)
                .orElseThrow(() -> new ResourceNotFoundException("Voiture not found with id: " + voitureId));
        voiture.setCommunicationDone(true);
        voitureRepository.save(voiture);
        return true;
    }
}
