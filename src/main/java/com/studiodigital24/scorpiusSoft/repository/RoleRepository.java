package com.studiodigital24.scorpiusSoft.repository;

import com.studiodigital24.scorpiusSoft.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
