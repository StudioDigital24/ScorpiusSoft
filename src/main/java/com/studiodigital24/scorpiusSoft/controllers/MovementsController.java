package com.studiodigital24.scorpiusSoft.controllers;

import com.studiodigital24.scorpiusSoft.entities.Movements;
import com.studiodigital24.scorpiusSoft.services.MovementsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController()
@RequestMapping("/movement")
public class MovementsController {
    @Autowired
    MovementsServices servicesMovement;

    @GetMapping("")
    public List<Movements> getMovements() {
        return this.servicesMovement.getMovements();
    }

    @GetMapping("/{id}")
    public Movements getMovement(@PathVariable("id") int id) {
        return this.servicesMovement.getMovement(id);
    }

    @PostMapping("")
    public RedirectView createMovement(@ModelAttribute Movements enterpriseNew, Model model) {
        model.addAttribute(enterpriseNew);
        this.servicesMovement.createMovement(enterpriseNew);
        return new RedirectView("/lista-movimientos");
    }

    @PatchMapping("/{id}")
    public RedirectView updateMovement(@PathVariable("id") long id, @RequestBody Movements datos) {
        this.servicesMovement.patchMovement(id, datos);
        return new RedirectView("/lista-movimientos");
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteMovement(@PathVariable("id") long id) {
        this.servicesMovement.deleteMovement(id);
        return new RedirectView("/lista-movimientos");
    }

}
