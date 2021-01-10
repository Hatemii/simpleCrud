package com.example.simpleCrud.Controller;

import com.example.simpleCrud.Entity.Master;
import com.example.simpleCrud.Service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/masterFields")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping
    public List<Master> getAllStudyFields() {
        return this.masterService.getAllStudyFields();
    }

    @GetMapping(value = "/{id}")
    public Master getStudyFieldById(@PathVariable("id") int id) {
        return this.masterService.getStudyFieldById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletetStudyFieldById(@PathVariable int id) {
        this.masterService.deletetStudyFieldById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateStudyField(@PathVariable int id,@RequestBody Master master) {
        this.masterService.updateStudyField(id, master);
    }

    @PostMapping("/insert")
    public void insertStudyField(@RequestBody Master master) {
        this.masterService.insertStudyField(master);
    }


}
