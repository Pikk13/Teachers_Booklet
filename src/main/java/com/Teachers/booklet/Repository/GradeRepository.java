package com.Teachers.booklet.Repository;

import com.Teachers.booklet.Model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface GradeRepository extends JpaRepository<Grade, LocalDateTime> {
}
