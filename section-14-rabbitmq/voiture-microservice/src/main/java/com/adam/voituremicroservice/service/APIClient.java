package com.adam.voituremicroservice.service;

import com.adam.voituremicroservice.dto.MarqueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "MARQUE", fallback = MarqueFallBack.class)
public interface APIClient {

    @GetMapping("/api/marques/{marque-code}")
    MarqueDto getMarqueByCode(@PathVariable("marque-code") String marqueCode);
}