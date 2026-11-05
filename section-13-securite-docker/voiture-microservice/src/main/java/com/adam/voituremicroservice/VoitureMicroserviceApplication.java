package com.adam.voituremicroservice;

import com.adam.voituremicroservice.entities.Voiture;
import com.adam.voituremicroservice.repos.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class VoitureMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(VoitureRepository voitureRepository) {
        return args -> {
            voitureRepository.save(Voiture.builder()
                    .voitName("Peugeot 208").voitCode("208").marqueCode("PG").build());
            voitureRepository.save(Voiture.builder()
                    .voitName("Peugeot 308").voitCode("308").marqueCode("PG").build());
            voitureRepository.save(Voiture.builder()
                    .voitName("Renault Clio").voitCode("CLIO").marqueCode("RN").build());
        };
    }
}