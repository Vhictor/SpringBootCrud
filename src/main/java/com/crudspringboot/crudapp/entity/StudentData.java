package com.crudspringboot.crudapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student_data")
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String matric;
    private String level;
    private String courset;
    private String coursec;
    private int score;



    public StudentData() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatric() {
        return matric;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCourset() {
        return courset;
    }

    public void setCourset(String courset) {
        this.courset = courset;
    }

    public String getCoursec() {
        return coursec;
    }

    public void setCoursec(String coursec) {
        this.coursec = coursec;
    }
}
