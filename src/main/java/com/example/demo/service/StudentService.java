package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void save(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);
    }
}
