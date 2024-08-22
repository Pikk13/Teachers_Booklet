package com.Teachers.booklet.Controller;

import com.Teachers.booklet.Model.StudentCard;
import com.Teachers.booklet.Service.StudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentCard")
public class StudentCardController {

    @Autowired
    StudentCardService studentCardService;


    @PostMapping("/createOrUpdate/{studentName}")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCard saveOrUpdateStudentCard(@PathVariable String studentName, @RequestBody StudentCard studentCard){
        return studentCardService.saveOrUpdateStudentCard(studentName, studentCard);
    }

    @GetMapping("/list")
    public List<StudentCard> getAllStudentCards(){
        return studentCardService.getAllStudentCards();
    }

    @GetMapping("/searchById/{id}")
    public Optional<StudentCard> getStudentCardById(@PathVariable Long id){
        return studentCardService.getStudentCardById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteStudentCard(@PathVariable Long id){
        studentCardService.deleteStudentCard(id);
    }

    @GetMapping("/byStudentName/{name}")
    public Optional<StudentCard> findStudentCardByStudentName(@PathVariable String name){
        return studentCardService.findStudentCardByStudentName(name);
    }
}
