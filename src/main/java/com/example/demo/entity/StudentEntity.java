package com.example.demo.entity;

import com.example.demo.dto.StudentDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter(AccessLevel.PRIVATE)
@Getter
@Table(name = "student_table")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String studentNumber;

    @Column(length = 20, nullable = false)
    private String studentName;

    @Column(length = 30, nullable = false)
    private String studentMobile;

    @Column(length = 50, nullable = false)
    private String studentMajor;


    // DTO -> Entity 변환 메서드
    public static StudentEntity toSaveEntity(StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentNumber(studentDTO.getStudentNumber());
        studentEntity.setStudentName(studentDTO.getStudentName());
        studentEntity.setStudentMajor(studentDTO.getStudentMajor());
        studentEntity.setStudentMobile(studentDTO.getStudentMobile());
        return studentEntity;
    }
}
