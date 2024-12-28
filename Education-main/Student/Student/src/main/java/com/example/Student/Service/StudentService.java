package com.example.Student.Service;

import com.example.Student.Model.Student;
import com.example.Student.Repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email).orElse(null);
    }

    public Student getStudentById(Long studentid){
        return studentRepository.findById(studentid).orElse(null);
    }

    public Student createStudent(@Valid Student student) {
        return studentRepository.save(student);
    }


    public Student updateStudent(Long studentid, @Valid Student student) {
    student.setStudentid(studentid);
    return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}