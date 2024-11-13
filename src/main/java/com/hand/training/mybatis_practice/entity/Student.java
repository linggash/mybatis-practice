package com.hand.training.mybatis_practice.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Student implements Serializable {

    private String id;

    private String name;

    private String birthday;

    private String sex;
}
