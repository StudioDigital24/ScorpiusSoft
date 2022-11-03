package com.studiodigital24.scorpiusSoft.repository;

import com.studiodigital24.scorpiusSoft.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
