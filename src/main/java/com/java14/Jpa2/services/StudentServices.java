package com.java14.Jpa2.services;

import com.java14.Jpa2.dto.StudentDTO;
import com.java14.Jpa2.request.InsertStudentRequest;

import java.util.List;

public interface StudentServices {
    List<StudentDTO> getAllStudent();
    StudentDTO addStudent(InsertStudentRequest Request);
}
