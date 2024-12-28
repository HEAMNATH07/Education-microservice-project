package com.example.Student.Controller;

import com.example.Student.DTO.CourseDto;
import com.example.Student.Model.Student;
import com.example.Student.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/findallstudent")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    public Student getStudentWithCourseDetails(@PathVariable Long studentid) {
        Student student = studentService.getStudentById(studentid);
        if (student != null) {
            CourseDto course = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:9090/api/courses/" + student.getCourseid())
                    .retrieve()
                    .bodyToMono(CourseDto.class)
                    .block();

            student.setCourseDto(course);
        }
        return student;
    }

    @PostMapping("/addstudent")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long studentid, @Valid @RequestBody Student student) {
        return studentService.updateStudent(studentid, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long studentid) {
        studentService.deleteStudent(studentid);
    }
}