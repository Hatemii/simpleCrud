package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
@Qualifier("sqlite")
public class MongoStudentDaoImpl implements StudentDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    public MongoStudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    @Override
    //    public Collection<Student> getAllStudents() {
    //        String url = "SELECT * FROM student";
    //        return jdbcTemplate.query(url, (resultSet, i) -> {
    //            int id = resultSet.getInt("id");
    //            String name = resultSet.getString("name");
    //            String course = resultSet.getString("course");
    //
    //            return new Student(id, name, course);
    //        });
    //    }

    @Override
    public Collection<Student> getAllStudents() {
        final String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("course"));
        });
    }


    //    @Override
    //    public Student getStudentById(int id) {
    //        String url = "SELECT * FROM student WHERE ID = ?";
    //        return jdbcTemplate.queryForObject(url, new Object[] {id}, (resultSet, i) -> {
    //            int student_id = resultSet.getInt("id");
    //            String student_name = resultSet.getString("name");
    //            String student_course = resultSet.getString("course");
    //
    //            return new Student(student_id, student_name, student_course);
    //        });
    //    }

    @Override
    public Student getStudentById(int id) {
        final String url = "SELECT * FROM student WHERE ID = ?";
        return jdbcTemplate.queryForObject(url, new Object[]{id}, (resultSet, i) -> {
            return new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("course"));
        });
    }


    @Override
    public void deletetStudentById(int id) {
        final String url = "DELETE FROM student WHERE ID = ?";
        jdbcTemplate.update(url, id);
    }

//    @Override
//    public void updateStudent(int id, Student student) {
//        final String url = "UPDATE student SET name = ?, course = ? WHERE ID = ?";
//        jdbcTemplate.update(url, student.getName(), student.getCourse(), id);
//    }

    @Override
    public void updateStudent(int id, Student student) {
        final String url = "UPDATE student SET " +
                "name = '" + student.getName() + "', " +
                "course = '" + student.getCourse() + "' " +
                "WHERE ID = " + id;

        jdbcTemplate.update(url);
    }


//    @Override
//    public void insertStudent(Student student) {
//        final String url = "INSERT INTO student (name, course) VALUES (?, ?)";
//        jdbcTemplate.update(url, student.getName(), student.getCourse());
//
//    }


    @Override
    public void insertStudent(Student student) {
        final String url = "INSERT INTO student (name, course)" +
                " VALUES ('" + student.getName() + "', '" + student.getCourse() + "')";

        jdbcTemplate.update(url);

    }

}

// jdbcTemplate.queryForObject -->> for single row or value
// jdbcTemplate.query -->> for multiple rows or list
