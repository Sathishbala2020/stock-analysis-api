package com.sat.stockanalysisapi.controller;

import com.sat.stockanalysisapi.entity.DowJonesDataset;
import com.sat.stockanalysisapi.service.DowJonesDataService;
import com.sat.stockanalysisapi.util.CSVUtil;
import com.sat.stockanalysisapi.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("stock/analysis")
public class DowJonesDataController {

    @Autowired
    DowJonesDataService dowJonesDataService;

    @PostMapping("/bulkupload")
    public ResponseEntity<ResponseMessage> uploadData(@RequestParam("file")MultipartFile file) {
        String message = "";
        try{
            if(CSVUtil.isCSVFormat(file)) {
                dowJonesDataService.uploadBulkDataSet(file);
                message = "File uploaded successfully!!";
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }
        } catch (Exception ex) {
            message = "File upload failed!!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
        message = "File format mismatch. Expected CSV!!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/getStockInfo/{stockTicker}")
    public ResponseEntity<List<DowJonesDataset>> getStockInfo(@PathVariable String stockTicker) {
        return new ResponseEntity<>(dowJonesDataService.findByStockTicker(stockTicker), HttpStatus.OK);
    }

    ß
}
