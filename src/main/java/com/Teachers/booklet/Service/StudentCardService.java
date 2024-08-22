package com.Teachers.booklet.Service;

import com.Teachers.booklet.Model.Student;
import com.Teachers.booklet.Model.StudentCard;
import com.Teachers.booklet.Repository.StudentCardRepository;
import com.Teachers.booklet.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentCardService {

    @Autowired
    private StudentCardRepository studentCardRepository;

    @Autowired
    StudentRepository studentRepository;


    public StudentCard saveOrUpdateStudentCard(String studentName, StudentCard studentCard) {
        Optional<Student> optionalStudent = studentRepository.findById(studentName);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentCard.setStudent(student);
            return studentCardRepository.save(studentCard);
        } else {
            throw new RuntimeException("Student not found with name: " + studentName);
        }
    }

    public List<StudentCard> getAllStudentCards() {
        return studentCardRepository.findAll();
    }

    public Optional<StudentCard> getStudentCardById(Long id) {
        return studentCardRepository.findById(id);
    }


    public void deleteStudentCard(Long id) {
        studentCardRepository.deleteById(id);
    }

    @Transactional
    public Optional<StudentCard> findStudentCardByStudentName(String name) {
        return Optional.ofNullable(studentCardRepository.findByStudentName(name));
    }
}