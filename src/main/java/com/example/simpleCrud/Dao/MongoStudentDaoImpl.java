package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("sqlite")
public class MongoStudentDaoImpl implements StudentDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    public MongoStudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Student> getAllStudents() {
        String url = "SELECT * FROM student";
        return jdbcTemplate.query(url, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String course = resultSet.getString("course");

            return new Student(id, name, course);
        });
    }

    @Override
    public Student getStudentById(int id) {
        String url = "SELECT * FROM student WHERE ID = ?";
        return jdbcTemplate.queryForObject(url, new Object[] {id}, (resultSet, i) -> {
            int student_id = resultSet.getInt("id");
            String student_name = resultSet.getString("name");
            String student_course = resultSet.getString("course");

            return new Student(student_id, student_name, student_course);
        });
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
