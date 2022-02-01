package com.sat.stockanalysisapi.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.io.Serializable;

@Data
public class StockDataVO implements Serializable {

    @CsvBindByName
    private String stock;

    @CsvBindByName
    private String quarter;

    @CsvBindByName
    private String date;

    @CsvBindByName
    private String open;

    @CsvBindByName
    private String high;

    @CsvBindByName
    private String low;

    @CsvBindByName
    private String close;

    @CsvBindByName
    private String volume;

    @CsvBindByName
    private String previousStockVolume;

    @CsvBindByName
    private String nextWeekOpen;

    @CsvBindByName
    private String nextWeekClose;

    @CsvBindByName
    private String percentChangeNextWeekPrice;
}
