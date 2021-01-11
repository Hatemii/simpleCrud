package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Master;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MasterDao implements MasterInterface{

    private JdbcTemplate jdbcTemplate;

    public MasterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Master> getAllStudyFields() {
        final String sql = "SELECT * FROM Master ORDER BY ID ASC";
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                return new Master(
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
    public Master getStudyFieldById(int id) {
        final String url = "SELECT * FROM Master WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(url, new Object[]{id}, (resultSet, i) -> {
                return new Master(
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
        final String url = "DELETE FROM Master WHERE id = " + id;

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void updateStudyField(int id, Master master) {
        final String url = "UPDATE Master SET " +
                "technology = '" + master.getTechnology() + "', " +
                "industrial = '" + master.getIndustrial() + "', " +
                "business = '" + master.getBusiness() + "', " +
                "political = '" + master.getPolitical() + "', " +
                "semester = '" + master.getSemester() + "' " +
                "WHERE id = " + id;

        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void insertStudyField(Master master) {
        final String url = "INSERT INTO Master (technology, industrial, business, political,semester)" +
                " VALUES ('" + master.getTechnology() + "', " +
                "'" + master.getIndustrial() + "', " +
                "'" + master.getBusiness() + "', " +
                "'" + master.getPolitical() + "', " +
                "'" + master.getSemester() + "')";
        try {
            jdbcTemplate.update(url);
        } catch (DataAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

