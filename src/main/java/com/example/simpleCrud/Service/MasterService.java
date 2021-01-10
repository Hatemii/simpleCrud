package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.MasterDao;
import com.example.simpleCrud.Entity.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterService {

    @Autowired
    private MasterDao masterDao;

    public List<Master> getAllStudyFields() {
        return this.masterDao.getAllStudyFields();
    }

    public Master getStudyFieldById(int id) {
        return this.masterDao.getStudyFieldById(id);
    }

    public void deletetStudyFieldById(int id) {
        this.masterDao.deletetStudyFieldById(id);
    }

    public void updateStudyField(int id, Master master) {
        this.masterDao.updateStudyField(id, master);
    }

    public void insertStudyField(Master master) {

        this.masterDao.insertStudyField(master);
    }


}
