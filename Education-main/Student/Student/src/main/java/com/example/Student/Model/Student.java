package com.example.Student.Model;


import com.example.Student.DTO.CourseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;



@Entity
@Table(name = "student")
public class Student {
    public Student(Long studentid, String name, String email, Long courseid,String Password) {
        this.studentid = studentid;
        this.name = name;
        this.email = email;
        this.courseid = courseid;
        this.Password=Password;

    }

    @Id
    private Long studentid;

    public Student() {
    }

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private Long courseid;

    private String Password;


    public void setCourseDto(CourseDto course) {
    }


    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank String email) {
        this.email = email;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
