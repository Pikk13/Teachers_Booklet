package com.Teachers.booklet.Repository;

import com.Teachers.booklet.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, String> {

}
