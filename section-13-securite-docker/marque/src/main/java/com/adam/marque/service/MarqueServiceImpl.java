package com.adam.marque.service;

import com.adam.marque.dto.MarqueDto;
import com.adam.marque.entities.Marque;
import com.adam.marque.repos.MarqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MarqueServiceImpl implements MarqueService {

    private MarqueRepository marqueRepository;

    @Override
    public MarqueDto getMarqueByCode(String code) {
        Marque m = marqueRepository.findByMarqueCode(code);
        return new MarqueDto(
                m.getId(),
                m.getNom(),
                m.getPays(),
                m.getMarqueCode()
        );
    }
}