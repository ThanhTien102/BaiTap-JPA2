package com.java14.Jpa2.controller;

import com.java14.Jpa2.entity.StudentEntity;
import com.java14.Jpa2.request.InsertStudentRequest;
import com.java14.Jpa2.respond.BaseRespond;
import com.java14.Jpa2.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping
    public ResponseEntity<?> getAllStudent()
    {
        return  ResponseEntity.ok(studentServices.getAllStudent());
    }
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody InsertStudentRequest request)
    {
        BaseRespond baseRespond= new BaseRespond();
        baseRespond.setData(studentServices.addStudent(request));
        baseRespond.setMessage("Thêm thành công");
        return  ResponseEntity.ok(baseRespond);
    }
}
