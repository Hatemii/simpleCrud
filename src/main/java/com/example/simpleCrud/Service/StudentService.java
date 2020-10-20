package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.StudentDaoInterface;
import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("sqlite")
    private StudentDaoInterface studentDaoInterface;

    // GET ALL STUDENTS
    public Collection<Student> getAllStudents() {
        return this.studentDaoInterface.getAllStudents();
    }

    // GET STUDENT BY ID
    public Student getStudentById(int id) {
        return this.studentDaoInterface.getStudentById(id);
    }

    // DELETE STUDENT BY ID
    public void deletetStudentById(int id) {
        this.studentDaoInterface.deletetStudentById(id);
    }

    // UPDATE STUDENT
    public void updateStudent(Student student) {
        this.studentDaoInterface.updateStudent(student);
    }

    // INSERT STUDENT
    public void insertStudent(Student student) {
        this.studentDaoInterface.insertStudent(student);
    }


}
