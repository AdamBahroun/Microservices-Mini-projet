package com.adam.marque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarqueDto {
    private Long id;
    private String nom;
    private String pays;
    private String marqueCode;
}