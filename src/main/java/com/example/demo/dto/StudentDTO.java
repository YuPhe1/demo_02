package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {

    private Long id;
    private String studentNumber;
    private String studentName;
    private String studentMobile;
    private String studentMajor;
}
