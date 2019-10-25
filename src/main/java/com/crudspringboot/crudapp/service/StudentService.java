package com.crudspringboot.crudapp.service;

import com.crudspringboot.crudapp.entity.Student;
import com.crudspringboot.crudapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student findStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student getUserWithMatricAndPassword(String matric, String password){
        return studentRepository.findStudentByMatricAndPassword(matric,password);
    }
}
