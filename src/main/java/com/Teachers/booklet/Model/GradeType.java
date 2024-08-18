package com.Teachers.booklet.Model;
import jakarta.persistence.OneToOne;


public enum GradeType {
    @OneToOne REPETITION,
    @OneToOne WRITTEN_TEST,
    @OneToOne OTHER,
    @OneToOne ACTIVITY,
    @OneToOne HOMEWORK,
    @OneToOne PRACTICAL_WORK
}
