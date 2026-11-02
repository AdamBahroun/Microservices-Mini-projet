package com.adam.voituremicroservice.service;

import com.adam.voituremicroservice.dto.APIResponseDto;
import com.adam.voituremicroservice.dto.MarqueDto;
import com.adam.voituremicroservice.dto.VoitureDto;
import com.adam.voituremicroservice.entities.Voiture;
import com.adam.voituremicroservice.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VoitureServiceImpl implements VoitureService {

    private VoitureRepository voitureRepository;
    private APIClient apiClient;

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
                v.getMarqueCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setVoitureDto(voitureDto);
        apiResponseDto.setMarqueDto(marqueDto);
        return apiResponseDto;
    }
}