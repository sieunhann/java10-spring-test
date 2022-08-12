package com.example.coursesample.controller;

import com.example.coursesample.model.Course;
import com.example.coursesample.service.CourseService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;
    // Ví dụ demo
    // Lấy danh sách tất cả khóa học
    @GetMapping("/courses")
    public List<Course> getAllCourse(@RequestParam(name = "type", required = false) String type,
                                     @RequestParam(name = "title", required = false) String title, @RequestParam(name = "topic", required = false) String topic) {
        if(type != null){
            return courseService.findByType(type, title, topic);
        }
        return courseService.findAll(title, topic);
    }

    // Lay thong tin 1 khoa hoc
    @GetMapping("/course")
    public Course getCourse(@RequestParam("id") int id){
        return courseService.findById(id);
    }
}
