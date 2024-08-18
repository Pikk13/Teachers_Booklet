package com.Teachers.booklet.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@ToString

public class GradeDTO {

    private LocalDateTime timeId;
    private Integer grade;
    private GradeType gradeType;
}

