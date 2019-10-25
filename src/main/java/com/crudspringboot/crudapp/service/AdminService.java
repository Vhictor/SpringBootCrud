package com.crudspringboot.crudapp.service;

import com.crudspringboot.crudapp.entity.Admin;
import com.crudspringboot.crudapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdminWithIdnumAndPassword(String adminID, String password){
        return adminRepository.findAdminByAdminAndPassword(adminID,password);
    }


}
