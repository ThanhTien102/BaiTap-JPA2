package com.java14.Jpa2.services.Imp;

import com.java14.Jpa2.dto.StudentDTO;
import com.java14.Jpa2.entity.StudentEntity;
import com.java14.Jpa2.repository.StudentRepository;
import com.java14.Jpa2.request.InsertStudentRequest;
import com.java14.Jpa2.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImp implements StudentServices {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll().stream()
                .map(item->{
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(item.getId());
                    studentDTO.setName(item.getName());
                    studentDTO.setEmail(item.getEmail());
                    return  studentDTO;
                }).toList();
    }

    @Override
    public StudentDTO addStudent(InsertStudentRequest Request) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(Request.getName());
        studentEntity.setEmail(Request.getEmail());

        studentRepository.save(studentEntity);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setName(Request.getName());
        studentDTO.setEmail(Request.getEmail());
        return   studentDTO;
    }
}
