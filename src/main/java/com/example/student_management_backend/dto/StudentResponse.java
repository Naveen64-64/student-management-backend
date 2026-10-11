package com.example.student_management_backend.dto;

public class StudentResponse {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String course;
    private String phone;

    public StudentResponse() {
    }

    public StudentResponse(
            Long id,
            String name,
            String email,
            Integer age,
            String course,
            String phone) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getPhone() {
        return phone;
    }
}