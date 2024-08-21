package com.Teachers.booklet.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
public class Grade {

  @Id
  private LocalDateTime timeId = LocalDateTime.now();
  private Integer grade;
  @Enumerated(EnumType.STRING)
  private GradeType gradeType;

  @ManyToOne
  @JoinColumn(name = "student_name") // specify the foreign key column
  @JsonIgnore
  private Student student;


}
