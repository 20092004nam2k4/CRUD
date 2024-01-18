package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class StaffFile {
    private Long id;
    private String name;
    private int age;
    private String email;
    private MultipartFile image;

    public StaffFile(Long id, String name, int age, String email, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.image = image;
    }

    public StaffFile(String name, int age, String email, MultipartFile image) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.image = image;
    }

    public StaffFile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
