package com.example.course.Controller;

import com.example.course.Model.Course;
import com.example.course.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{name}")
    public Course getCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }

    @PostMapping("/addcourse")
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long courseid, @Valid @RequestBody Course course ) {
        return courseService.updateCourse(courseid,course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long courseid) {
        courseService.deleteCourse(courseid);
    }
}