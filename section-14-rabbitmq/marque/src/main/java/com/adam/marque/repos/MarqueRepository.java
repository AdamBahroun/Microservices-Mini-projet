package com.adam.marque.repos;

import com.adam.marque.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
    Marque findByMarqueCode(String marqueCode);
}