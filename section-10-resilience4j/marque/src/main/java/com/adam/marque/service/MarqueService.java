package com.adam.marque.service;

import com.adam.marque.dto.MarqueDto;

public interface MarqueService {
    MarqueDto getMarqueByCode(String code);
}