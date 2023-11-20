package com.exe1.jwtexe1.service;

import com.exe1.jwtexe1.dao.RoleDao;
import com.exe1.jwtexe1.dao.UserDao;
import com.exe1.jwtexe1.entity.Role;
import com.exe1.jwtexe1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerNewUser(User user){
        Role role=roleDao.findById("User").get();
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setUserPassword(getEncoderPassword(user.getUserPassword()));
        return userDao.save(user);
    }
    public void initROlesAndUser(){
        Role adminRole =new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole =new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser =new User();
        adminUser.setUserName("admin123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword(getEncoderPassword("admin@pass"));
        Set<Role> adminRoles =new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        /*User user =new User();
        user.setUserName("youssef123");
        user.setUserFirstName("youssef");
        user.setUserLastName("Ayachi");
        user.setUserPassword(getEncoderPassword("youssef@pass"));
        Set<Role> userRoles =new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);*/

    }
    public String getEncoderPassword(String password ){
        return passwordEncoder.encode(password);

    }
}
