package com.precize.score.services;

import com.precize.score.Entity.SatResult;
import com.precize.score.dao.SatResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SatScoreServiceImpl implements SatScoreService{

    @Autowired
    private SatResultDao satResultDao;

    @Override
    public SatResult insertData(SatResult satResult) {
        satResultDao.save(satResult);
        return satResult;
    }

    @Override
    public List<SatResult> getData() {
        return satResultDao.findAll();
    }

    @Override
    public Integer getRank(String name) {
        List<SatResult> satResultList = satResultDao.findAll();
        Integer rank = null;
        SortedSet<Integer> ts
                = new TreeSet<Integer>();

        for(SatResult satResult:satResultList){
            ts.add(satResult.getSatScore());
            if(satResult.getName() ==  name) rank = satResult.getSatScore();
        }

        List<Integer> temp = ts.stream().toList();
        Collections.reverse(temp);

        for(int i=0; i<temp.size();i++){
            if( temp.get(i) == rank) return i+1;
        }

        return 0;
    }

    @Override
    public SatResult updateData(String name, Integer score) {

        SatResult satResultTemp = null;
        List<SatResult> satResultList = satResultDao.findAll();
        for(SatResult satResult:satResultList){
            if(satResult.getName() == name){
                satResult.setSatScore(score);
                satResultTemp = satResult;
            }
        }

        satResultDao.save(satResultTemp);
        return satResultTemp;
    }

    @Override
    public SatResult deleteData(String name) {
        List<SatResult> satResultList = satResultDao.findAll();
        for(SatResult satResult:satResultList){
            if(satResult.getName() == name){
                satResultDao.deleteById(satResult.getStudentId());
                return satResult;
            }
        }
        return null;
    }
}
