package com.example.enrollservice.client;

import com.example.enrollservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class StudentClient {
    private RestTemplate restTemplate;
    private final String studentServiceURL;

    @Autowired
    public StudentClient(@Value("${student-service.url}") final String studentServiceURL) {
        System.out.println("Inside PatientClient: "+studentServiceURL);
        this.studentServiceURL = studentServiceURL;
        restTemplate = new RestTemplate();
    }

    public ResponseEntity<Student> searchStudent(int id){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(studentServiceURL)
                .path("/student/" + id);
        System.out.println("Path: "+builder.toUriString());

        ResponseEntity<Student> responseEntity = restTemplate.getForEntity(builder.toUriString(), Student.class);
        return responseEntity;
    }
}
