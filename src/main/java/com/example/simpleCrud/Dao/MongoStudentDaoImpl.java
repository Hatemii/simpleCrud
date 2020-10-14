package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDaoInterface{
    @Override
    public Collection<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deletetStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
