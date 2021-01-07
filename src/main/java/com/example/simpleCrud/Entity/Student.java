package com.example.simpleCrud.Entity;

import javax.validation.constraints.NotBlank;
import java.util.*;

public class Student {
    private int id;

    @NotBlank(message = "Name may not be null")
    private String name;

    @NotBlank(message = "Surname may not be null")
    private String surname;

    @NotBlank(message = "Field may not be null")
    private String field;

    private int semester;

    public Student(int id, String name, String surname,String field, int semester) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.field = field;
        this.semester = semester;
    }

    // for json query
    public Student() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
