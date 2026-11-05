package com.adam.voituremicroservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String voitName;
    private String voitCode;
    private String marqueCode;
    private String email;
    private String mobileNumber;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean communicationDone = false;
}
