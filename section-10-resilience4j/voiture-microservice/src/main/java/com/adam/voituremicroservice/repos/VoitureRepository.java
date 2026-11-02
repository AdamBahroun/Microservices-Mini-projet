package com.adam.voituremicroservice.repos;

import com.adam.voituremicroservice.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}