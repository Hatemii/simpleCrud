package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.StudentDaoInterface;
import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    @Qualifier("studentsAccess")
    private StudentDaoInterface studentDaoInterface;

    // GET ALL STUDENTS
    public List<Student> getAllStudents() {
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
    public void updateStudent(int id, Student student) {
        this.studentDaoInterface.updateStudent(id, student);
    }

    // INSERT STUDENT
    public void insertStudent(Student student) {
        this.studentDaoInterface.insertStudent(student);
    }

    // Count
    public int countStudents() {
        return this.studentDaoInterface.countStudents();
    }

    // Delete all records
    public void deleteAllRecords() {
        this.studentDaoInterface.deleteAllRecords();
    }

    // delete all where name starts with
    public void deleteAllWhere(String s) {
        this.studentDaoInterface.deleteAllWhere(s);
    }

    // insert multiple records
    public void insertMultiple(List<Student> students) {
        this.studentDaoInterface.insertMultiple(students);
    }

    // json query
    public List<Student> jsonQuery() {
        return this.studentDaoInterface.jsonQuery();
    }
}
