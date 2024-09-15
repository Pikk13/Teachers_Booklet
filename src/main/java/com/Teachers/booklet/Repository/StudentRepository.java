package com.Teachers.booklet.Repository;

import com.Teachers.booklet.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
@Query("SELECT s FROM Student s WHERE LOWER(s.classCategory) = LOWER(:classCategory)")
   public List<Student> findByClassCategory(@Param("classCategory") String classCategory);
}
