package com.sat.stockanalysisapi.service;

import com.sat.stockanalysisapi.entity.DowJonesDataset;
import com.sat.stockanalysisapi.model.StockDataVO;
import com.sat.stockanalysisapi.repository.DowJonesRepository;
import com.sat.stockanalysisapi.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class DowJonesDataServiceImpl implements DowJonesDataService{

    @Autowired
    private DowJonesRepository dowJonesRepository;

    @Override
    public void uploadBulkDataSet(MultipartFile file) {
        dowJonesRepository.saveAll(CSVUtil.mapCSVToObject(file));
    }

    @Override
    public void saveDataSet(DowJonesDataset dataSet) {
        this.dowJonesRepository.save(dataSet);
    }

    @Override
    public List<DowJonesDataset> findByStockTicker(String stockTicker) {
        Optional<List<DowJonesDataset>> optionalDataSets = this.dowJonesRepository.findByStock(stockTicker);
        List<DowJonesDataset> datasets = null;

        if(optionalDataSets.isPresent()){
            datasets = optionalDataSets.get();
        }else{
            throw new RuntimeException("Stock Ticker not found --> "+stockTicker);
        }
        return datasets;
    }
}
