package com.adam.voituremicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoitureDto {
    private Long id;
    private String voitName;
    private String voitCode;
    private String marqueCode;
}