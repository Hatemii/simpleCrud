package com.example.simpleCrud.Service;

import com.example.simpleCrud.Dao.BachelorDao;
import com.example.simpleCrud.Entity.Bachelor;
import com.example.simpleCrud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BachelorService {

    @Autowired
    private BachelorDao bachelorDao;

    public List<Bachelor> getAllStudyFields() {
        return this.bachelorDao.getAllStudyFields();
    }

    public Bachelor getStudyFieldById(int id) {
        return this.bachelorDao.getStudyFieldById(id);
    }

    public void deletetStudyFieldById(int id) {
        this.bachelorDao.deletetStudyFieldById(id);
    }

    public void updateStudyField(int id, Bachelor bachelor) {
        this.bachelorDao.updateStudyField(id, bachelor);
    }

    public void insertStudyField(Bachelor bachelor) {
        this.bachelorDao.insertStudyField(bachelor);
    }


}
