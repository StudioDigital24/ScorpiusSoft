package com.studiodigital24.scorpiusSoft.services;


import com.studiodigital24.scorpiusSoft.entities.Movement;

import java.util.List;

public interface MovementService {

    List<Movement> getAllMovement();
    void saveMovement(Movement movement);
    Movement getMovementById(long id);
    void deleteMovementById(long id);

}

