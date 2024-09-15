package com.Teachers.booklet.Controller;

import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addOrUpdateStudent(@RequestBody Student student) { return studentService.addOrUpdateStudent(student);
    }

    @GetMapping("/list")
    public List<Student> studentList() {
        return studentService.studentList();
    }


    @GetMapping("/semesterAverage/{name}")
    public Double semesterGradeAverage(@PathVariable String name) {
        return studentService.semesterGradeAverage(name);
    }

    @GetMapping("/endYearAverage/{name}")
    public Double endOfYearGradeAverage(@PathVariable String name) {
        return studentService.endOfYearGradeAverage(name);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteStudentByName(@PathVariable String name){
        studentService.deleteStudentByName(name);
    }

    @GetMapping("/searchByName/{name}")
    public Student searchByName(@PathVariable String name){
        return studentService.searchByName(name);
    }

    @GetMapping("/classCategories")
    public List<String> findAllClassCategories() {
        return studentService.findAllClassCategories();
    }

    @GetMapping("/namesByClassCategory/{classCategory}")
    public List<String> findStudentNamesByClassCategory(@PathVariable String classCategory) {
        return studentService.findStudentNamesByClassCategory(classCategory);
    }
}
