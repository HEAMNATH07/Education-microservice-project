package com.example.course.Service;

import com.example.course.Model.Course;
import com.example.course.Repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByName(name).orElse(null);
    }

    public Course createCourse(@Valid Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseid, @Valid Course course) {
        course.setCourseid(courseid);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseid) {
        courseRepository.deleteById(courseid);
    }
}