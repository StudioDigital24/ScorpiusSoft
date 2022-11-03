package com.studiodigital24.scorpiusSoft.services;

import com.studiodigital24.scorpiusSoft.entities.Employee;
import com.studiodigital24.scorpiusSoft.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    EmployeeRepository repositorio;

    public EmployeeServices(EmployeeRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Employee> getEmployees() {
        return this.repositorio.findAll();
    }

    public Employee getEmployee(long id) {
        return this.repositorio.findById(id).get();
    }

    public Employee createEmployee(Employee employeeNew) {
        return this.repositorio.save(employeeNew);
    }

    public void updateEmployee(long id, Employee updateEmployee) {
        Employee employeeUpdate = this.repositorio.findById(id).get();
        if (this.repositorio.findById(id).isPresent()) {
            if (updateEmployee.getId() != 0) employeeUpdate.setId(updateEmployee.getId());
            if (updateEmployee.getName() != null) employeeUpdate.setName(updateEmployee.getName());
            if (updateEmployee.getEmail() != null) employeeUpdate.setEmail(updateEmployee.getEmail());
            this.repositorio.save(employeeUpdate);
        }
    }

    public void deteleEmployee(long id) {
        this.repositorio.deleteById(id);
    }

}