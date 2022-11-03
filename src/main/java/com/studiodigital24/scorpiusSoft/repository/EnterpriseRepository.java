package com.studiodigital24.scorpiusSoft.repository;

import com.studiodigital24.scorpiusSoft.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {

}
