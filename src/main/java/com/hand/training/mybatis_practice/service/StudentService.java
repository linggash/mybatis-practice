package com.hand.training.mybatis_practice.service;

import com.hand.training.mybatis_practice.entity.Student;
import com.hand.training.mybatis_practice.model.StudentResponse;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    StudentResponse findByID(Long id);

    StudentResponse create(Student student);
}
