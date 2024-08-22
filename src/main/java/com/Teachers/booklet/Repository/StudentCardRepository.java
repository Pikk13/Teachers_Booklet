package com.Teachers.booklet.Repository;

import com.Teachers.booklet.Model.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard, Long> {
    StudentCard findByStudentName(String name);
}
