package com.adam.voituremicroservice.service;

import com.adam.voituremicroservice.dto.MarqueDto;
import org.springframework.stereotype.Component;

@Component
public class MarqueFallBack implements APIClient {

    @Override
    public MarqueDto getMarqueByCode(String marqueCode) {
        return null;
    }
}
