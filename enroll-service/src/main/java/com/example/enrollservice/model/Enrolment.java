package com.example.enrollservice.model;

public class Enrolment {
    private String courseName;
    private int id;
    private String name;

    public Enrolment() {
    }

    public Enrolment(String courseName, int id, String name) {
        this.courseName = courseName;
        this.id = id;
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
