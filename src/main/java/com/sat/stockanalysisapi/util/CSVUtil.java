package com.sat.stockanalysisapi.util;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sat.stockanalysisapi.entity.DowJonesDataset;
import com.sat.stockanalysisapi.model.StockDataVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

public class CSVUtil {

    public static List<DowJonesDataset> mapCSVToObject(MultipartFile file) {
        List<DowJonesDataset> dataSet;
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            dataSet = new CsvToBeanBuilder(reader)
                    .withType(DowJonesDataset.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build()
                    .parse();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to parse CSV file:", exception);
        }
        return dataSet;
    }

    public static boolean isCSVFormat(MultipartFile file) {
        if(!APIConstants.BULK_UPLOAD_FILE_TYPE.equalsIgnoreCase(file.getContentType())){
            return false;
        }
        return true;
    }

    public static void mapVOToEntity(StockDataVO stockDataVO, DowJonesDataset dataset) {
        dataset.setDate(stockDataVO.getDate());
        dataset.setClose(stockDataVO.getClose());
        dataset.setHigh(stockDataVO.getHigh());
        dataset.setLow(stockDataVO.getLow());
        dataset.setNextWeekClose(stockDataVO.getNextWeekClose());
        dataset.setNextWeekOpen(stockDataVO.getNextWeekOpen());
        dataset.setPercentChangeNextWeekPrice(stockDataVO.getPercentChangeNextWeekPrice());
        dataset.setPreviousStockVolume(stockDataVO.getPreviousStockVolume());
        dataset.setQuarter(stockDataVO.getQuarter());
        dataset.setStock(stockDataVO.getStock());
        dataset.setVolume(stockDataVO.getVolume());
    }
}
