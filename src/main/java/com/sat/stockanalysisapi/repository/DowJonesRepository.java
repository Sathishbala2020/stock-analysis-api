package com.sat.stockanalysisapi.repository;

import com.sat.stockanalysisapi.entity.DowJonesDataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DowJonesRepository extends JpaRepository<DowJonesDataset, Long> {

    Optional<List<DowJonesDataset>> findByStock(String stock);
}
