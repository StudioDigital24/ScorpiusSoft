package com.studiodigital24.scorpiusSoft.controllers;

import com.studiodigital24.scorpiusSoft.entities.Employee;
import com.studiodigital24.scorpiusSoft.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    EmployeeServices servicio;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.servicio.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") long id) throws Exception {
        return this.servicio.getEmployee(id);
    }

    @PostMapping("/newEmployee")
    public RedirectView createEmployee(@ModelAttribute Employee employeeNew, Model model) {
        model.addAttribute(employeeNew);
        this.servicio.createEmployee(employeeNew);
        return new RedirectView("/employees");
    }

    @PatchMapping("/{id}")
    public RedirectView updateEmployee(@PathVariable("id") long id, @RequestBody Employee datos) {
        this.servicio.updateEmployee(id, datos);
        return new RedirectView("/employees");
    }

    @DeleteMapping("/deleteEmployees/{id}")
    public RedirectView deteleEmployee(@PathVariable("id") int id) {
        this.servicio.deteleEmployee(id);
        return new RedirectView("/employees");
    }
}