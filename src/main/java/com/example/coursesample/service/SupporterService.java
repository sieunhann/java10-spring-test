package com.example.coursesample.service;

import com.example.coursesample.exception.NotFoundException;
import com.example.coursesample.model.Supporter;
import com.example.coursesample.repository.SupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupporterService {
    @Autowired
    SupporterRepository supporterRepository;

    public Supporter findById(int id){
        return supporterRepository.findById(id).orElseThrow(() ->{
            throw new NotFoundException("Supporter doesn't exist");
        });
    }
}
