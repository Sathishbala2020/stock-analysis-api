package com.sat.stockanalysisapi.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "dow_jones_dataset")
public class DowJonesDataset {

        @Id
        @Column(name = "stock", nullable = false)
        @CsvBindByName(column = "stock")
        private String stock;

        @Column(name = "quarter")
        @CsvBindByName(column = "quarter")
        private String quarter;

        @Id
        @Column(name = "date")
        @CsvBindByName(column = "date")
        private String date;

        @Column(name = "open")
        @CsvBindByName(column = "date")
        private String open;

        @Column(name = "high")
        @CsvBindByName(column = "high")
        private String high;

        @Column(name = "low")
        @CsvBindByName(column = "low")
        private String low;

        @Column(name = "close")
        @CsvBindByName(column = "close")
        private String close;

        @Column(name = "volume")
        @CsvBindByName(column = "volume")
        private String volume;

        @Column(name = "previous_weeks_volume")
        @CsvBindByName(column = "previous_weeks_volume")
        private String previousStockVolume;

        @Column(name = "next_weeks_open")
        @CsvBindByName(column = "next_weeks_open")
        private String nextWeekOpen;

        @Column(name = "next_weeks_close")
        @CsvBindByName(column = "next_weeks_close")
        private String nextWeekClose;

        @Column(name = "percent_change_next_weeks_price")
        @CsvBindByName(column = "percent_change_next_weeks_price")
        private String percentChangeNextWeekPrice;

}