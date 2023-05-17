package com.precize.score.dao;

import com.precize.score.Entity.SatResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatResultDao extends JpaRepository<SatResult, Long> {
}
