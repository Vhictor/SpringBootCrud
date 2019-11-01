package com.crudspringboot.crudapp.repository;

import com.crudspringboot.crudapp.entity.Student;
import com.crudspringboot.crudapp.entity.StudentData;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.Optional;

public interface StudentDataRepository extends JpaRepository<StudentData, Long> {

    Optional<StudentData> findByMatric(String matric);
    //     @Modifying (clearAutomatically = true)
//    @Query("UPDATE StudentData   data SET data.score=score WHERE data.id=:id")
//    void updateScore(@Param("id") Long id, @Param("score") int score);
}
