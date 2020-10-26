package com.example.simpleCrud.Entity;

import javax.validation.constraints.NotBlank;
import java.util.*;

public class Student {
    private int id;

    @NotBlank(message = "Name may not be null")
    private String name;

    @NotBlank(message = "Course may not be null")
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
