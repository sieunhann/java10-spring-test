package com.example.coursesample.repository;

import com.example.coursesample.database.FakeDB;
import com.example.coursesample.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    // Repository : Chứa các phương thức để thao tác với database

    // Ví dụ demo
    // Lấy danh sách tất cả khóa học
    public List<Course> findAll() {
        return FakeDB.courses;
    }

    // Lay danh sach theo type
    public List<Course> findByType(String type){
        return FakeDB.courses.stream()
                .filter(course -> course.getType().equals(type))
                .toList();
    }


    // Lay khoa hoc theo id
    public Optional<Course> findById(int id){
        return FakeDB.courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }
}
