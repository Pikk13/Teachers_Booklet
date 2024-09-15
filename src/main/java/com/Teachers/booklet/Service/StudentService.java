package com.Teachers.booklet.Service;

import com.Teachers.booklet.Exception.StudentNotFoundException;
import com.Teachers.booklet.Model.Grade;
import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public Student findStudentByName(String name){
        return studentRepo.findById(name).orElseThrow(()->
                new StudentNotFoundException("Student not found with this name: " + name));
    }

    public Student addOrUpdateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(student.getName());
        optionalStudent.ifPresent(value -> studentRepo.delete(value));
        return studentRepo.save(student);
    }

    public List<Student> studentList() {
        List<Student> students = studentRepo.findAll();
        if (students.isEmpty()) {
            System.out.println("There is no student in database");
        }
        return students;
    }

    public Double semesterGradeAverage(String name) {
        Student student = findStudentByName(name);

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
        Student student = findStudentByName(name);

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
        Student student = findStudentByName(name);

            studentRepo.delete(student);
    }

    public Student searchByName(String name){
        return findStudentByName(name);
        }

    public List<String> findAllClassCategories() {
        return studentRepo.findAll()
                .stream()
                .map(Student::getClassCategory)
                .distinct()
                .collect(Collectors.toList());
    }
@Transactional
    public List<String> findStudentNamesByClassCategory(String classCategory) {
       try {
           return studentRepo.findByClassCategory(classCategory)
                   .stream()
                   .map(Student::getName)
                   .collect(Collectors.toList());
       } catch (Exception e) {
           //log the error
           e.printStackTrace();
           throw new RuntimeException("Nem listázza ki a tanulók neveit a 6-B-ből");
       }
    }
    }


