package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StudentDTO studentDTO){
        studentService.save(studentDTO);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String findAll(Model model){
        List<StudentDTO> studentDTOList = studentService.findAll();
        model.addAttribute("studentList", studentDTOList);
        return "list";
    }
}
