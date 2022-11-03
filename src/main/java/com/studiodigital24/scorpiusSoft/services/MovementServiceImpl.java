package com.studiodigital24.scorpiusSoft.services;

import com.studiodigital24.scorpiusSoft.entities.Movement;
import com.studiodigital24.scorpiusSoft.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public List <Movement> getAllMovement() {
        return movementRepository.findAll();
    }

    @Override
    public void saveMovement(Movement movement) {
        this.movementRepository.save(movement);
    }

    @Override
    public Movement getMovementById(long id) {
        Optional<Movement> optional = movementRepository.findById(id);
        Movement movement = null;
        if (optional.isPresent()) {
            movement = optional.get();
        } else {
            throw new RuntimeException(" movement not found for id :: " + id);
        }
        return movement;
    }

    @Override
    public void deleteMovementById(long id) {
        this.movementRepository.deleteById(id);
    }

}