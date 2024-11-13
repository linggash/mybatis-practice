package com.hand.training.mybatis_practice.service.impl;

import com.hand.training.mybatis_practice.entity.Student;
import com.hand.training.mybatis_practice.mapper.StudentMapper;
import com.hand.training.mybatis_practice.model.StudentResponse;
import com.hand.training.mybatis_practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public StudentResponse findByID(Long id) {
        Student student = studentMapper.findById(id);
        return new StudentResponse(
                student.getName(),
                student.getSex(),
                student.getBirthday()
        );
    }

    @Override
    @Transactional
    public StudentResponse create(Student student) {
        int studentResult = studentMapper.create(student);
        return StudentResponse.builder()
                .name(student.getName())
                .sex(student.getSex())
                .birthday(student.getBirthday())
                .build();
    }
}
