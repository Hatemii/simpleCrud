package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentDaoInterface {
    // GET ALL STUDENTS
    List<Student> getAllStudents();

    // GET STUDENT BY ID
    Student getStudentById(int id);

    // DELETE STUDENT BY ID
    void deletetStudentById(int id);

    // UPDATE STUDENT
    void updateStudent(int id, Student student);

    // INSERT STUDENT
    void insertStudent(Student student);

    // Count
    int countStudents();

    // delete all records
    void deleteAllRecords();

    // delete all records where name starts with
    void deleteAllWhere(String s);

    // insert multiple records
    void insertMultiple(List<Student> students);

}
