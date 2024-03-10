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

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<String> generateFarmReport(@PathVariable Long farmerId) {
        String farmReport = reportService.generateFarmReport(farmerId);
        return ResponseEntity.ok(farmReport);
    }

    @GetMapping("/crop/{cropTypeId}")
    public ResponseEntity<String> generateCropReport(@PathVariable Long cropTypeId) {
        String cropReport = reportService.generateCropReport(cropTypeId);
        return ResponseEntity.ok(cropReport);
    }
}
