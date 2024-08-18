package com.Teachers.booklet.Service;

import com.Teachers.booklet.Model.Grade;
import com.Teachers.booklet.Model.GradeDTO;
import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Repository.GradeRepository;
import com.Teachers.booklet.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepo;

    @Autowired
    StudentRepository studentRepo;

    @Transactional
    public void addGrade(GradeDTO gradeDTO, String name) {
        // Find the student by studentId
        Student student = new Student();
        Optional<Student> optionalStudent = studentRepo.findById(name);
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        } else System.out.println("There is no student in this name!");

        // Create a new Grade entity
        Grade grade = new Grade();
        grade.setGrade(gradeDTO.getGrade());
        grade.setGradeType(gradeDTO.getGradeType());

        // Automatically set timeId to the current date and time if it's not provided
        grade.setTimeId(LocalDateTime.now());

        grade.setStudent(student);

        // Save the Grade entity
        gradeRepo.save(grade);

        // Optionally, update the student's gradeList
        if (student.getGradeList() != null) {
            student.getGradeList().add(grade);
        } else {
            student.setGradeList(new ArrayList<>());
            student.getGradeList().add(grade);
        }
        studentRepo.save(student);
    }

    public List<GradeDTO> listGradeByStudent(String name) {
        return studentRepo.findById(name).orElse(null).getGradeList().stream()
                .map(grade -> {
                    GradeDTO dto = new GradeDTO();
                    dto.setTimeId(grade.getTimeId());
                    dto.setGrade(grade.getGrade());
                    dto.setGradeType(grade.getGradeType());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
