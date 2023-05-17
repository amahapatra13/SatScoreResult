package com.precize.score.services;

import com.precize.score.Entity.SatResult;

import java.util.List;

public interface SatScoreService {

    public SatResult insertData(SatResult satResult);

    public List<SatResult> getData();

    public Integer getRank(String name);
    public SatResult updateData(String name, Integer score);

    public SatResult deleteData(String name);
}
