package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.StudentDao;
import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    // GET ALL STUDENTS
    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    // GET STUDENT BY ID
    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }

    // DELETE STUDENT BY ID
    public void deletetStudentById(int id){
        this.studentDao.deletetStudentById(id);
    }
}
