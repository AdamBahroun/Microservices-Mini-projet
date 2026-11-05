package com.adam.voituremicroservice.service;

import com.adam.voituremicroservice.dto.APIResponseDto;

public interface VoitureService {
    APIResponseDto getVoitureById(Long id);
}