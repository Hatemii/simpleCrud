package com.example.simpleCrud.Controller;

import com.example.simpleCrud.Entity.Bachelor;
import com.example.simpleCrud.Service.BachelorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bachelorFields")
public class BachelorController {

    @Autowired
    private BachelorService bachelorService;

    @GetMapping
    public List<Bachelor> getAllStudyFields() {
        return this.bachelorService.getAllStudyFields();
    }

    @GetMapping(value = "/{id}")
    public Bachelor getStudyFieldById(@PathVariable("id") int id) {
        return this.bachelorService.getStudyFieldById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletetStudyFieldById(@PathVariable int id) {
        this.bachelorService.deletetStudyFieldById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateStudyField(@PathVariable int id,@RequestBody Bachelor bachelor) {
        this.bachelorService.updateStudyField(id, bachelor);
    }

    @PostMapping("/insert")
    public void insertStudyField(@RequestBody Bachelor bachelor) {
        this.bachelorService.insertStudyField(bachelor);
    }

}
