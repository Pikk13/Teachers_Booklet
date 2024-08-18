package com.Teachers.booklet.Service;

import com.Teachers.booklet.Model.Grade;
import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Repository.GradeRepository;
import com.Teachers.booklet.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    GradeRepository gradeRepo;

    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> studentList() {
        List<Student> students = studentRepo.findAll();
        if (students.isEmpty()) {
            System.out.println("Nincs adatbázisba felvett diák");
        }
        return students;
    }

    public Double semesterGradeAverage(String name) {
        // Find the student by studentId
        Student student = new Student();
        Optional<Student> optionalStudent = studentRepo.findById(name);
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        } else System.out.println("There is no student in this name!");

        List<Grade> gradeList = new ArrayList<>();
        gradeList = student.getGradeList();
        Double semesterGrade = 0.0;
        int sumGrades = 0;
        int numOfGrades = 0;

        for (int i = 0; i < gradeList.size(); i++) {
            LocalDateTime referenceDateEnd = LocalDateTime.of(2024, 12, 25, 0, 0, 0, 507976);
            LocalDateTime referenceDateStart = LocalDateTime.of(2024, 8, 1, 0, 0, 0, 507976);

            if (gradeList.get(i).getTimeId().isBefore(referenceDateEnd)
                    && gradeList.get(i).getTimeId().isAfter(referenceDateStart)) {
                sumGrades += gradeList.get(i).getGrade();
                numOfGrades++;
                semesterGrade = sumGrades / (double) numOfGrades;
            } else System.out.println("There is no grades in the first semester!");
        }

        student.setSemesterGrade(semesterGrade);
        studentRepo.save(student);
        return semesterGrade;
    }
}

