package com.example.enrollservice;

import com.example.enrollservice.client.StudentClient;
import com.example.enrollservice.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest/*(webEnvironment = SpringBootTest.WebEnvironment.NONE)*/
@AutoConfigureStubRunner(ids = {"com.example:student-service:+:stubs:8080"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class EnrollServiceApplicationTests {

    @Autowired
    StudentClient studentClient;

    @Test
    public void givenID_whenSearchForStudent_shouldReturnStudent() {
        int id = 1;
        ResponseEntity<Student> studentRes = studentClient.searchStudent(id);

        then(studentRes.getStatusCode().equals(200));
        then(studentRes.getBody().getId() == id);
        then(studentRes.getBody().getName().equals("James"));

    }

}
