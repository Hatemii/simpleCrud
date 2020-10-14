package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.StudentDao;
import com.example.simpleCrud.Entity.Student;

import java.util.Collection;

public class StudentService {
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }
}
