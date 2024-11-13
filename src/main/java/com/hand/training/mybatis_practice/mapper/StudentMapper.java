package com.hand.training.mybatis_practice.mapper;

import com.hand.training.mybatis_practice.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Student findById(Long id);

    int create(Student student);
}
