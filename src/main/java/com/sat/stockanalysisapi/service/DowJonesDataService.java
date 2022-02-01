package com.sat.stockanalysisapi.service;

import com.sat.stockanalysisapi.entity.DowJonesDataset;
import com.sat.stockanalysisapi.model.StockDataVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DowJonesDataService {
    void uploadBulkDataSet(MultipartFile file);

    void saveDataSet(DowJonesDataset dataSet);

    List<DowJonesDataset> findByStockTicker(String stockTicker);
}
