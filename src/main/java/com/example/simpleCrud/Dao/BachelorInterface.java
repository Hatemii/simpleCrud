package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Bachelor;

import java.util.List;

public interface BachelorInterface {

    List<Bachelor> getAllStudyFields();

    Bachelor getStudyFieldById(int id);

    void deletetStudyFieldById(int id);

    void updateStudyField(int id, Bachelor bachelor);

    void insertStudyField(Bachelor bachelor);

}
