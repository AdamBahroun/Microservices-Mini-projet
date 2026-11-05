package com.adam.voituremicroservice.service;

import com.adam.voituremicroservice.dto.APIResponseDto;
import com.adam.voituremicroservice.dto.VoitureDto;

public interface VoitureService {
    APIResponseDto getVoitureById(Long id);

    VoitureDto createVoiture(VoitureDto voitureDto);

    boolean updateCommunicationStatus(Long voitureId);
}
