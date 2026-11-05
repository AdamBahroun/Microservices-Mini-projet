package com.adam.voituremicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private VoitureDto voitureDto;
    private MarqueDto marqueDto;
}