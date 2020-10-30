package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
@Qualifier("studentsAccess")
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
    public List<Student> getAllStudents() {
        final String sql = "SELECT * FROM student ORDER BY ID DESC";
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                return new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("course"));
            });
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
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
        try {
            return jdbcTemplate.queryForObject(url, new Object[]{id}, (resultSet, i) -> {
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("course"));
            });
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public void deletetStudentById(int id) {
        final String url = "DELETE FROM student WHERE ID = " + id;

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
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

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
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

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public int countStudents() {
        final String sql = "SELECT COUNT(*) FROM student";
        // not best practice !
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    // delete all records
    @Override
    public void deleteAllRecords() {
        final String sql = "DELETE FROM student";

        try {
            jdbcTemplate.update(sql);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }


    // delete all where name starts with
    @Override
    public void deleteAllWhere(String s) {
        final String sql = "DELETE FROM student WHERE Name LIKE '" + s + "%'";

        try {
            jdbcTemplate.update(sql);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }


    // insert multiple records
    @Override
    public void insertMultiple(List<Student> students) {
        final String sql = "INSERT INTO Student (name,course) VALUES (?, ?)";

        try {
            jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Student st = students.get(i);
                    ps.setString(1, st.getName());
                    ps.setString(2, st.getCourse());
                }

                @Override
                public int getBatchSize() {
                    return students.size();
                }
            });
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // json Query
    @Override
    public List<Student> jsonQuery() {
        final String sql = "SELECT * FROM Student ORDER BY ID DESC";

        List<Map<String, Object>> studentList = jdbcTemplate.queryForList(sql);

        List<Student> personList = new ArrayList<Student>();

        try {
            for (final Map<String, Object> row : studentList) {
                Student student = new Student();
                student.setId((Integer) row.get("id"));
                student.setName((String) row.get("name"));
                student.setCourse((String) row.get("course"));
                personList.add(student);
            }
            return personList;

        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}

// jdbcTemplate.queryForObject -->> for single row or value
// jdbcTemplate.query -->> for multiple rows or list
