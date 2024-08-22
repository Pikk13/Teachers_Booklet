package com.Teachers.booklet.Service;

import com.Teachers.booklet.Model.Grade;
import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public Student addOrUpdateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(student.getName());
        optionalStudent.ifPresent(value -> studentRepo.delete(value));
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
        Student student = new Student();
        Optional<Student> optionalStudent = studentRepo.findById(name);
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        } else System.out.println("There is no student in this name!");

        List<Grade> gradeList;
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

    public Double endOfYearGradeAverage(String name) {
        Student student = new Student();
        Optional<Student> optionalStudent = studentRepo.findById(name);
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
        } else System.out.println("There is no student in this name!");

        List<Grade> gradeList;
        gradeList = student.getGradeList();
        Double endYearGrade = 0.0;
        int sumGrades = 0;
        int numOfGrades = 0;

        for (int i = 0; i < gradeList.size(); i++) {
            LocalDateTime referenceDateEnd = LocalDateTime.of(2025, 6, 25, 0, 0, 0, 507976);
            LocalDateTime referenceDateStart = LocalDateTime.of(2024, 8, 1, 0, 0, 0, 507976);

            if (gradeList.get(i).getTimeId().isBefore(referenceDateEnd)
                    && gradeList.get(i).getTimeId().isAfter(referenceDateStart)) {
                sumGrades += gradeList.get(i).getGrade();
                numOfGrades++;
                endYearGrade = sumGrades / (double) numOfGrades;
            } else System.out.println("There is no grades in the first semester!");
        }

        student.setEndOfYearGrade(endYearGrade);
        studentRepo.save(student);
        return endYearGrade;
    }

    public void deleteStudentByName(String name){
        Student student;
        Optional<Student> optionalStudent = studentRepo.findById(name);
        if (optionalStudent.isPresent()) {
            student = optionalStudent.get();
            studentRepo.delete(student);
        } else System.out.println("There is no student in this name!");
    }

    public Optional<Student> searchByName(String name){
        return studentRepo.findById(name);
        }
    }


