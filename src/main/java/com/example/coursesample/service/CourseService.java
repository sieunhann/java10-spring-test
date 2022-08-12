package com.example.coursesample.service;

import com.example.coursesample.exception.NotFoundException;
import com.example.coursesample.model.Course;
import com.example.coursesample.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // Ví dụ demo
    // Lấy danh sách tất cả khóa học
    public List<Course> findAll(String title, String topic) {
        List<Course> list = courseRepository.findAll();
        if(title != null){
            if(topic == null){
                return getByTitle(title, list);
            }
            return getByTopicAndTitle(title,topic, list);
        } else {
            if(topic != null){
                return getByTopic(topic, list);
            }
            return list;
        }
    }

    // Lay danh sach theo Type
    public List<Course> findByType(String type, String title, String topic){
        List<Course> typeList = courseRepository.findByType(type);
        if(title != null){
            if(topic == null){
                return getByTitle(title, typeList);
            }
            return getByTopicAndTitle(title,topic, typeList);
        } else {
            if(topic != null){
                return getByTopic(topic, typeList);
            }
            return typeList;
        }
    }

    // Lay danh sach theo title
    public List<Course> getByTitle(String title, List<Course> courses){
        return courses.stream()
                .filter(course -> course.getTitle().contains(title))
                .toList();
    }

    // Lay danh sach theo topic
    public List<Course> getByTopic(String topic, List<Course> courses){
        return courses.stream()
                .filter(course -> course.getTopics().contains(topic))
                .toList();
    }

    // Lay danh sach theo Topic va Title
    public List<Course> getByTopicAndTitle(String title, String topic, List<Course> courses){
        return courses.stream()
                .filter(course -> course.getTitle().contains(title))
                .filter(course -> course.getTopics().contains(topic))
                .toList();
    }

    // Xem thong tin khoa hoc
    public Course findById(int id){
        return courseRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(id + ": doesn't exist");
        });
    }
}
