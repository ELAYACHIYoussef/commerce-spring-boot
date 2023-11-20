package com.exe1.jwtexe1.service;

import com.exe1.jwtexe1.dao.RoleDao;
import com.exe1.jwtexe1.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
