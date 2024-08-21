package com.Teachers.booklet.Controller;

import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
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
}
