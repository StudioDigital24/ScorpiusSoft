package com.studiodigital24.scorpiusSoft.services;

import com.studiodigital24.scorpiusSoft.entities.Movements;
import com.studiodigital24.scorpiusSoft.repository.MovementsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovementsServices {

    MovementsRepository repositorio;

    public MovementsServices(MovementsRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Movements> getMovements() {
        return this.repositorio.findAll();
    }

    public Movements getMovement(long id){
        return this.repositorio.findById(id).get();
    }

    public Movements createMovement(Movements movementNew) {
        return this.repositorio.save(movementNew);
    }

    public void patchMovement(long id, Movements updateMovement) {
        Movements movementUpdate = this.repositorio.findById(id).get();
        if (this.repositorio.findById(id).isPresent()) {
            if (updateMovement.getId()!= null) movementUpdate.setId(updateMovement.getId());
            if (updateMovement.getConcept() != null) movementUpdate.setConcept(updateMovement.getConcept());
            if (updateMovement.getAmount() != 0) movementUpdate.setAmount(updateMovement.getAmount());
            this.repositorio.save(movementUpdate);
        }
    }

    public void deleteMovement(long id) {
        this.repositorio.deleteById(id);
    }
}