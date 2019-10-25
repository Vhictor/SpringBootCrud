package com.crudspringboot.crudapp.repository;

import com.crudspringboot.crudapp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findAdminByAdminAndPassword(String adminId, String password);
}
