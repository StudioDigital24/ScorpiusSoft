package com.studiodigital24.scorpiusSoft.controllers;

import com.studiodigital24.scorpiusSoft.entities.Employee;
import com.studiodigital24.scorpiusSoft.entities.Enterprise;
import com.studiodigital24.scorpiusSoft.entities.Movement;
import com.studiodigital24.scorpiusSoft.services.EmployeeService;
import com.studiodigital24.scorpiusSoft.services.EnterpriseService;
import com.studiodigital24.scorpiusSoft.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MovementController {

    private static final RedirectView REDIRECT_VIEW = new RedirectView();
    @Autowired
    private MovementService movementsService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/movement")
    public String viewHomePage(Model model) {
        model.addAttribute("listMovement", movementsService.getAllMovement());
        return "/movement";
    }

    @GetMapping("/showNewMovementForm")
    public String showNewMovementForm(Model model) {
        Movement movement = new Movement();
        List<Employee> empleadoSelect = employeeService.getAllEmployees();
        List<Enterprise> enterpriseSelect = enterpriseService.getAllEnterprise();
        model.addAttribute("movement", movement);
        model.addAttribute("empleadoSelect",empleadoSelect);
        model.addAttribute("enterpriseSelect",enterpriseSelect);
        return "new_movement";
    }

    @PostMapping("/saveMovement")
    public RedirectView saveMovement(@ModelAttribute("movement") Movement movement) {
        REDIRECT_VIEW.setUrl("/movement");
        movementsService.saveMovement(movement);
        return REDIRECT_VIEW;
    }

    @GetMapping("/showFormForUpdateMovement/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Movement movement = movementsService.getMovementById(id);
        List<Employee> empleadoSelect = employeeService.getAllEmployees();
        List<Enterprise> enterpriseSelect = enterpriseService.getAllEnterprise();
        model.addAttribute("movement", movement);
        model.addAttribute("empleadoSelect",empleadoSelect);
        model.addAttribute("enterpriseSelect",enterpriseSelect);
        return "update_movement";
    }

    @GetMapping("/deleteMovement/{id}")
    public RedirectView deleteMovement(@PathVariable(value = "id") long id) {
        REDIRECT_VIEW.setUrl("/movement");
        this.movementsService.deleteMovementById(id);
        return REDIRECT_VIEW;
    }
}