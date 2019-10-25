package com.crudspringboot.crudapp.repository;

import com.crudspringboot.crudapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

public Student findStudentByMatricAndPassword(String matric, String password);

}
