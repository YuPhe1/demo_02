package com.example.demo.dto;

import com.example.demo.entity.StudentEntity;
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

    public static StudentDTO toSaveDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = studentEntity.getId();
        studentDTO.studentNumber = studentEntity.getStudentNumber();
        studentDTO.studentName = studentEntity.getStudentName();
        studentDTO.studentMobile = studentEntity.getStudentMobile();
        studentDTO.studentMajor = studentEntity.getStudentMajor();
        return studentDTO;
    }
}
