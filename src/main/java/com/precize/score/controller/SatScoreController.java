package com.precize.score.controller;

import com.precize.score.Entity.SatResult;
import com.precize.score.services.SatScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SatScoreController {

    @Autowired
    private SatScoreService satScoreService;

    @PostMapping(path = "/insertData", consumes = "application/json")
    public SatResult insertData(@RequestBody SatResult satResult) {
        return this.satScoreService.insertData(satResult);
    }

    @GetMapping(path = "/getdata")
    public List<SatResult> getData(){
        return this.satScoreService.getData();
    }

    @GetMapping(path = "/getRank/{student_name}")
    public Integer getRank(@PathVariable("student_name") String name){
        return this.satScoreService.getRank(name);
    }

    @PutMapping(path = "/updatescore/{student_name}/{score}")
    public SatResult updateScore(@PathVariable("student_name") String name,@PathVariable("score") Integer score){
        return this.satScoreService.updateData(name, score);
    }

    @DeleteMapping(path = "/deleterecord/{student_name}")
    public SatResult deleteRecord(@PathVariable("student_name") String name){
        return this.satScoreService.deleteData(name);
    }
}
