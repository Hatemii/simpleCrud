package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
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

    // GET ALL STUDENTS
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    // GET STUDENT BY ID
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    // DELETE STUDENT BY ID
    public void deletetStudentById(int id){
        this.students.remove(id);
    }

    // UPDATE STUDENT
    public void updateStudent(Student student){
        Student s = students.get(student.getId());

        s.setId(student.getId());
        s.setName(student.getName());
        s.setCourse(student.getCourse());

        students.put(student.getId(),student);
    }

}
