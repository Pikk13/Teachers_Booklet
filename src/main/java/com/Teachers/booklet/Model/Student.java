package com.Teachers.booklet.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
@Table(name = "StudentTable")
public class Student {

    @Id
    @Column(name = "name")
    private String name;
    private String subject;
    private String classCategory;
    private String teachersName;
    private String schoolYear;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> gradeList;
    private Double semesterGrade;
    private Double endOfYearGrade;

    @OneToOne(mappedBy = "student")
    private StudentCard studentCard;



    }


