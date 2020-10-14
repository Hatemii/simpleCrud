package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;
import java.util.*;

public class StudentDao {
    private static Map<Integer, Student> students;

    static{
        students = new HashMap<Integer,Student>(){
            {
                put(1,new Student(1,"Lebron","Computer Science"));
                put(2,new Student(2,"Steph","Computer Network"));
                put(3,new Student(3,"Damian","Computer Technology"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }
}
