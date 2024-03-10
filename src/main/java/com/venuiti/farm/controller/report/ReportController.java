package com.venuiti.farm.controller.report;

import com.venuiti.farm.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<String> generateFarmReport(@PathVariable Long farmId) {
        String farmReport = reportService.generateFarmReport(farmId);
        return ResponseEntity.ok(farmReport);
    }

    @GetMapping("/crop/{cropType}")
    public ResponseEntity<String> generateCropReport(@PathVariable String cropType) {
        String cropReport = reportService.generateCropReport(cropType);
        return ResponseEntity.ok(cropReport);
    }
}
