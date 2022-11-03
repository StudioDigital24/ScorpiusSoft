package com.studiodigital24.scorpiusSoft.controllers;

import com.studiodigital24.scorpiusSoft.entities.Enterprise;
import com.studiodigital24.scorpiusSoft.services.EnterpriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController()
@RequestMapping("/enterprises")
public class EnterpriseController {
    @Autowired
    EnterpriseServices servicioEmpresa;

    @GetMapping("")
    public List<Enterprise> getEnterprises() {
        return this.servicioEmpresa.getEnterprises();
    }

    @GetMapping("/{id}")
    public Enterprise getEnterprise(@PathVariable("id") int id) {
        return this.servicioEmpresa.getEnterprise(id);
    }

    @PostMapping("")
    public RedirectView createEnterprise(@ModelAttribute Enterprise enterpriseNew, Model model) {
        model.addAttribute(enterpriseNew);
        this.servicioEmpresa.createEnterprise(enterpriseNew);
        return new RedirectView("/enterprises");
    }

    @PatchMapping("/{id}")
    public RedirectView updateEnterprise(@PathVariable("id") long id, @RequestBody Enterprise datos) {
        this.servicioEmpresa.updateEnterprise(id, datos);
        return new RedirectView("/enterprises");
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteEmpresa(@PathVariable("id") long id) {
        this.servicioEmpresa.deleteEnterprise(id);
        return new RedirectView("/enterprises");
    }

}
