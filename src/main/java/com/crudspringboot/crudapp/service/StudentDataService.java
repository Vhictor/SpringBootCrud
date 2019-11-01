package com.crudspringboot.crudapp.service;

import com.crudspringboot.crudapp.entity.StudentData;
import com.crudspringboot.crudapp.repository.StudentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDataService {

    @Autowired
  private StudentDataRepository repository;

   public List<StudentData> listAll() {
       return (List<StudentData>) repository.findAll();
   }

   public void addCourse(StudentData studentData){
       repository.save(studentData);
   }

   public StudentData findCourseById(Long id){
    return    repository.findById(id).get();
   }

    public Optional<StudentData> findStudentByMatric(String matric){
        return    repository.findByMatric(matric);
    }

//    @Transactional
//   public void updateCourseScore(int score, Long id){
//        repository.updateScore(id,score);
//   }


   public void delete(Long id){
       repository.deleteById(id);
   }


}
