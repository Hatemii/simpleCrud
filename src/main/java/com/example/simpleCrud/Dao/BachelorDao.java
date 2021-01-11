package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Bachelor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BachelorDao implements BachelorInterface {

    private final JdbcTemplate jdbcTemplate;

    public BachelorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Bachelor> getAllStudyFields() {
        final String sql = "SELECT * FROM Bachelor ORDER BY Semester ASC";
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                return new Bachelor(
                        resultSet.getInt("id"),
                        resultSet.getString("technology"),
                        resultSet.getString("industrial"),
                        resultSet.getString("business"),
                        resultSet.getString("political"),
                        resultSet.getInt("semester")
                );
            });
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Bachelor getStudyFieldById(int id) {
        final String url = "SELECT * FROM Bachelor WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(url, new Object[]{id}, (resultSet, i) -> {
                return new Bachelor(
                        resultSet.getInt("id"),
                        resultSet.getString("technology"),
                        resultSet.getString("industrial"),
                        resultSet.getString("business"),
                        resultSet.getString("political"),
                        resultSet.getInt("semester")

                );
            });
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void deletetStudyFieldById(int id) {
        final String url = "DELETE FROM Bachelor WHERE id = " + id;

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void updateStudyField(int id, Bachelor bachelor) {
        final String url = "UPDATE Bachelor SET " +
                "technology = '" + bachelor.getTechnology() + "', " +
                "industrial = '" + bachelor.getIndustrial() + "', " +
                "business = '" + bachelor.getBusiness() + "', " +
                "political = '" + bachelor.getPolitical() + "', " +
                "semester = '" + bachelor.getSemester() + "' " +
                "WHERE id = " + id;

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void insertStudyField(Bachelor bachelor) {
        final String url = "INSERT INTO Bachelor (technology, industrial, business, political, semester)" +
                " VALUES ('" + bachelor.getTechnology() + "', " +
                "'" + bachelor.getIndustrial() + "', " +
                "'" + bachelor.getBusiness() + "', " +
                "'" + bachelor.getPolitical() + "', " +
                "'" + bachelor.getSemester() +"')";

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
