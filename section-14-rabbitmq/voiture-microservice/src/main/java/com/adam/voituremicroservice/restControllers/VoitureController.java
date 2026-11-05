package com.adam.voituremicroservice.restControllers;

import com.adam.voituremicroservice.config.Configuration;
import com.adam.voituremicroservice.dto.APIResponseDto;
import com.adam.voituremicroservice.dto.VoitureDto;
import com.adam.voituremicroservice.service.VoitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voitures")
@RequiredArgsConstructor
public class VoitureController {
    private final VoitureService voitureService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getVoitureById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(voitureService.getVoitureById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createVoiture(@RequestBody VoitureDto voitureDto) {
        voitureService.createVoiture(voitureDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Voiture created successfully");
    }

    // @Value("${build.version}")
    // private String buildVersion;

    // @GetMapping("/version")
    // public ResponseEntity<String> version() {
    //     return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    // }

    // @Autowired
    // Configuration configuration;

    // @GetMapping("/author")
    // public ResponseEntity<String> retrieveAuthorInfo() {
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .body(configuration.getName() + " " + configuration.getEmail());
    // }
}
