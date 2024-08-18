package com.Teachers.booklet.Controller;


import com.Teachers.booklet.Model.Grade;
import com.Teachers.booklet.Model.GradeDTO;

import com.Teachers.booklet.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/add/{name}")
    public void addGrade(@RequestBody GradeDTO gradeDTO, @PathVariable String name) {
        gradeService.addGrade(gradeDTO, name);
    }
    @GetMapping("/gradeList/{name}")
    public List<GradeDTO> listGradeByStudent (@PathVariable String name){
       return gradeService.listGradeByStudent(name);
    }
}
