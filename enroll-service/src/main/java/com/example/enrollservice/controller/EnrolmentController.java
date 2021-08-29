package com.example.enrollservice.controller;

import com.example.enrollservice.client.StudentClient;
import com.example.enrollservice.model.Enrolment;
import com.example.enrollservice.model.Student;
import com.example.enrollservice.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EnrolmentController {
    @Autowired
    private EnrolmentService enrolmentService;
    @Autowired
    private StudentClient studentClient;

    @GetMapping(value = "/enrolments")
    public List<Enrolment> getEnrolments(){
        return enrolmentService.getEnrolments();
    }

    @PostMapping(value = "add-enrolment")
    public ResponseEntity<Enrolment> addEnrolment(@RequestBody Enrolment enrolment){
        ResponseEntity<Student> student = studentClient.searchStudent(enrolment.getId());
        if(student.getBody() == null){
            System.out.printf("Not present");
            return ResponseEntity.notFound().build();
        }
        enrolment = enrolmentService.enroll(enrolment);
        return ResponseEntity.accepted().body(enrolment);
    }
}
