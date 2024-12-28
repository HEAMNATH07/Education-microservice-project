package com.example.course.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private Long courseid;

    @NotBlank
    private String name;

    private Long studentid;

    public Course() {
    }

    public Course(Long courseid, String name, Long studentid) {
        this.courseid = courseid;
        this.name = name;
        this.studentid = studentid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }


}


