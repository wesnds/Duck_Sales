package com.example.demo.controllers;

import com.example.demo.services.ReportService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/{reportFormat}")
    public String getReport(@PathVariable @NotNull String reportFormat) throws Exception {
        reportService.generateReport(reportFormat);
        return "report generated";
    }
}
