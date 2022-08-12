package com.example.coursesample.controller;

import com.example.coursesample.model.Supporter;
import com.example.coursesample.service.SupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SupporterController {
    @Autowired
    SupporterService supporterService;

    @GetMapping("/supporter")
    public Supporter getSupporter(@RequestParam("id") int id){
        return supporterService.findById(id);
    }
}
