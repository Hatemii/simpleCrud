package com.example.simpleCrud.Dao;

import com.example.simpleCrud.Entity.Master;

import java.util.List;

public interface MasterInterface {
    List<Master> getAllStudyFields();

    Master getStudyFieldById(int id);

    void deletetStudyFieldById(int id);

    void updateStudyField(int id, Master master);

    void insertStudyField(Master master);

}


