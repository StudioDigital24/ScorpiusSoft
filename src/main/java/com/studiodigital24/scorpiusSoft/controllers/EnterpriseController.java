package com.studiodigital24.scorpiusSoft.controllers;

import com.studiodigital24.scorpiusSoft.entities.Enterprise;
import com.studiodigital24.scorpiusSoft.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EnterpriseController {

    private static final RedirectView REDIRECT_VIEW = new RedirectView();
    @Autowired
    private EnterpriseService enterpriseService;

    // display list of employees
    @GetMapping("/enterprise")
    public String viewHomePage(Model model) {
        model.addAttribute("listEnterprise", enterpriseService.getAllEnterprise());
        return "enterprise";
    }

    @GetMapping("/showNewEnterpriseForm")
    public String showNewEnterpriseForm(Model model) {
        // create model attribute to bind form data
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "new_enterprise";
    }

    @PostMapping("/saveEnterprise")
    public RedirectView saveEnterprise(@ModelAttribute("enterprise") Enterprise enterprise) {
        REDIRECT_VIEW.setUrl("/enterprise");
        enterpriseService.saveEnterprise(enterprise);
        return REDIRECT_VIEW;
    }

    @GetMapping("/showFormForUpdateEnterprise/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        model.addAttribute("enterprise", enterprise);
        return "update_enterprise";
    }

    @GetMapping("/deleteEnterprise/{id}")
    public RedirectView deleteEnterprise(@PathVariable(value = "id") long id) {
        REDIRECT_VIEW.setUrl("/enterprise");
        this.enterpriseService.deleteEnterpriseById(id);
        return REDIRECT_VIEW;
    }
}