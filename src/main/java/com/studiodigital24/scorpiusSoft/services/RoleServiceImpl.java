package com.studiodigital24.scorpiusSoft.services;

import com.studiodigital24.scorpiusSoft.entities.Role;
import com.studiodigital24.scorpiusSoft.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List <Role> getAllRole() {
        return roleRepository.findAll();
    }


}