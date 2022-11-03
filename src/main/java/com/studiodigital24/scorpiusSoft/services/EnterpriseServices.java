package com.studiodigital24.scorpiusSoft.services;

import com.studiodigital24.scorpiusSoft.entities.Enterprise;
import com.studiodigital24.scorpiusSoft.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServices {

    EnterpriseRepository repositorio;

    public EnterpriseServices(EnterpriseRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Enterprise> getEnterprises() {
        return this.repositorio.findAll();
    }

    public Enterprise getEnterprise(long id) {
        return this.repositorio.findById(id).get();
    }

    public Enterprise createEnterprise(Enterprise enterpriseNew) {
        return this.repositorio.save(enterpriseNew);
    }

    public void updateEnterprise(long id, Enterprise enterprise) {
        Enterprise updateEnterprise = this.repositorio.findById(id).get();
        if (this.repositorio.findById(id).isPresent()) {
            if (enterprise.getId()!= 0) updateEnterprise.setId(enterprise.getId());
            if (enterprise.getAddress() != null)
                updateEnterprise.setAddress(enterprise.getAddress());
            if (enterprise.getNit() != null) updateEnterprise.setNit(enterprise.getNit());
            if (enterprise.getPhone() != null) updateEnterprise.setPhone(enterprise.getPhone());
            if (enterprise.getName() != null) updateEnterprise.setName(enterprise.getName());
            this.repositorio.save(updateEnterprise);
        }
    }

    public void deleteEnterprise(long id) {
        this.repositorio.deleteById(id);
    }
}
