package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void save(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentNumber(studentDTO.getStudentNumber());
        studentEntity.setStudentName(studentDTO.getStudentName());
        studentEntity.setStudentMajor(studentDTO.getStudentMajor());
        studentEntity.setStudentMobile(studentDTO.getStudentMobile());
        studentRepository.save(studentEntity);
    }
}
