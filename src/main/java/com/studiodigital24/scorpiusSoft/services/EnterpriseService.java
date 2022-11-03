package com.studiodigital24.scorpiusSoft.services;

import com.studiodigital24.scorpiusSoft.entities.Enterprise;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> getAllEnterprise();
    void saveEnterprise(Enterprise enterprise);
    Enterprise getEnterpriseById(long id);
    void deleteEnterpriseById(long id);
}

