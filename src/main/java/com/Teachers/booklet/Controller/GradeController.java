package com.Teachers.booklet.Controller;

import com.Teachers.booklet.Model.GradeDTO;
import com.Teachers.booklet.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/add/{name}")
    public ResponseEntity<Map<String,String>> addGrade(@RequestBody GradeDTO gradeDTO, @PathVariable String name) {
        gradeService.addGrade(gradeDTO, name);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Grade added successfully!");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/gradeList/{name}")
    public List<GradeDTO> listGradeByStudent(@PathVariable String name) {
        return gradeService.listGradeByStudent(name);
    }

    @DeleteMapping("/delete/{studentName}/{timeId}")
    public ResponseEntity<String> deleteGradeByTimeId(
            @PathVariable String studentName,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeId) {

        gradeService.deleteGradeByTimeId(studentName, timeId);
        return ResponseEntity.ok("Grade deleted successfully.");
    }


}
