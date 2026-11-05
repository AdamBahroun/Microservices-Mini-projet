package com.adam.voituremicroservice.functions;

import com.adam.voituremicroservice.service.VoitureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class VoitureFunctions {

    @Bean
    public Consumer<Long> updateCommunication(VoitureService voitureService) {
        return voitureId -> {
            log.info("Updating Communication status for the voiture Id : {}", voitureId);
            voitureService.updateCommunicationStatus(voitureId);
        };
    }
}
