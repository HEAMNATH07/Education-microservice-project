package com.example.Student.DTO;


public class CourseDto {
    private Long courseid;

    public CourseDto() {
    }

    private String name;

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseDto(Long courseid, String name) {
        this.courseid = courseid;
        this.name = name;
    }
}
