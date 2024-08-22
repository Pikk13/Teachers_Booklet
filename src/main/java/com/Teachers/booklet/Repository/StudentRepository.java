package com.Teachers.booklet.Repository;

import com.Teachers.booklet.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
