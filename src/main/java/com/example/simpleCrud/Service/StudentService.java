package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.StudentDao;
import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    private StudentDao studentDao;

    @Autowired
    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }
}
