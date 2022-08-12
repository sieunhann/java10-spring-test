package com.example.coursesample.repository;

import com.example.coursesample.database.FakeDB;
import com.example.coursesample.model.Supporter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SupporterRepository {
    public Optional<Supporter> findById(int id){
        return FakeDB.supporters.stream()
                .filter(sup -> sup.getId() == id)
                .findFirst();
    }
}
