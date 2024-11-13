package com.hand.training.mybatis_practice.controller;

import com.hand.training.mybatis_practice.entity.Student;
import com.hand.training.mybatis_practice.model.StudentResponse;
import com.hand.training.mybatis_practice.model.WebResponse;
import com.hand.training.mybatis_practice.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private  StudentService studentService;

    @GetMapping(path = "/{id}")
    @ApiOperation("findById")
    WebResponse<StudentResponse> findById(@PathVariable Long id) {
        StudentResponse student = studentService.findByID(id);
        return WebResponse.<StudentResponse>builder().data(student).build();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation("create")
    WebResponse<StudentResponse> create(@RequestBody Student student) {
        log.info("isi", student);
        StudentResponse response = studentService.create(student);
        return WebResponse.<StudentResponse>builder().data(response).build();
    }
}
