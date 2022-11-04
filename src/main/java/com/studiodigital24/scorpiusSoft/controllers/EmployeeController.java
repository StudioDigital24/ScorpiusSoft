package com.studiodigital24.scorpiusSoft.controllers;

import com.studiodigital24.scorpiusSoft.entities.Employee;
import com.studiodigital24.scorpiusSoft.entities.Enterprise;
import com.studiodigital24.scorpiusSoft.entities.Role;
import com.studiodigital24.scorpiusSoft.services.EmployeeService;
import com.studiodigital24.scorpiusSoft.services.EnterpriseService;
import com.studiodigital24.scorpiusSoft.services.RoleService;
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
public class EmployeeController {

    private static final RedirectView REDIRECT_VIEW = new RedirectView();
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private RoleService roleService;

    @GetMapping("employee")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employee";
    }

    @GetMapping("showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee user= new Employee();
        List<Enterprise> departamentosSelect = enterpriseService.getAllEnterprise();
        List<Role> role = roleService.getAllRole();
        model.addAttribute("user",user);
        model.addAttribute("roleSelect",role);
        model.addAttribute("departamentosSelect",departamentosSelect);
        return "new_employee";
    }

    @PostMapping("saveEmployee")
    public RedirectView saveEmployee(@ModelAttribute("employee") Employee employee) {
        REDIRECT_VIEW.setUrl("/employee");
        employeeService.saveEmployee(employee);
        return REDIRECT_VIEW;
    }

    @GetMapping("showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee user = employeeService.getEmployeeById(id);
        List<Enterprise> departamentosSelect = enterpriseService.getAllEnterprise();
        List<Role> role = roleService.getAllRole();
        model.addAttribute("user",user);
        model.addAttribute("roleSelect",role);
        model.addAttribute("departamentosSelect",departamentosSelect);
        return "update_employee";
    }

    @GetMapping("deleteEmployee/{id}")
    public RedirectView deleteEmployee(@PathVariable(value = "id") long id) {
        REDIRECT_VIEW.setUrl("/employee");
        this.employeeService.deleteEmployeeById(id);
        return REDIRECT_VIEW;
    }

}