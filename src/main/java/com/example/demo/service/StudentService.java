package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Long save(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);
        // DTO -> Entity 변환을 위한 메서드 호출
        StudentEntity studentEntity = StudentEntity.toSaveEntity(studentDTO);
        Long saveId = studentRepository.save(studentEntity).getId();
        return saveId;
    }

    public List<StudentDTO> findAll() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        /*
            List<StudentEntity> -> List<StudentDTO>로 옮겨 담는 코드 작성
            Entity -> DTO 변환하는 메서드느 DTO에 정의
         */
        studentEntityList.forEach(entity -> {
            studentDTOList.add(StudentDTO.toSaveDTO(entity));
        });
        return studentDTOList;
    }

    public StudentDTO findById(Long id) {
//        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
//        if (optionalStudentEntity.isPresent()) {
//            // 있다.
//            StudentEntity studentEntity = optionalStudentEntity.get();
//            return StudentDTO.toSaveDTO(studentEntity);
//        } else {
//            // 없다.
//            return null;
//        }
        // Optional 객체를 까는데 만약에 없다면 예외 처리
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return StudentDTO.toSaveDTO(studentEntity);
    }

    public void update(StudentDTO studentDTO) {
        StudentEntity studentEntity = StudentEntity.toUpdateEntity(studentDTO);
        /*
            save() 에 넘기는 엔티티 객체에 pk 값이 들어 있으면 update 쿼리가 나가고
            pk 값이 없으면 insert 쿼리가 나감.
         */
        studentRepository.save(studentEntity);
    }
}
