package com.example.enrollservice.service;

import com.example.enrollservice.model.Enrolment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrolmentService {
    private static List<Enrolment> enrolments = new ArrayList<>();

    static {
        enrolments.add(new Enrolment("Maths", 1, "James"));
    }

    public Enrolment enroll(Enrolment enrolment){
        enrolments.add(enrolment);
        return enrolment;
    }

    public List<Enrolment> getEnrolments(){
        return enrolments;
    }
}
