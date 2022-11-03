package com.studiodigital24.scorpiusSoft.services;


import com.studiodigital24.scorpiusSoft.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);

}
