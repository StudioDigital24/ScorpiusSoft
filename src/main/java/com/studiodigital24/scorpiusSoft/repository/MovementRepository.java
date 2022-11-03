package com.studiodigital24.scorpiusSoft.repository;

import com.studiodigital24.scorpiusSoft.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
