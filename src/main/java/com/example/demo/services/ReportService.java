package com.example.demo.services;

import com.example.demo.models.SalesModel;
import com.example.demo.repositories.SaleRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    SaleRepository saleRepository;

    public String generateReport(@NotNull String reportFormat) throws Exception {
        String path = "F:\\Windows\\Weslley\\Documentos\\cursos\\java\\duck_sales\\src\\main\\reports";
        List<SalesModel> salesList = saleRepository.findAll();
        File file = new File(path);

        if (file.exists()) {
            if (reportFormat.equalsIgnoreCase("pdf")) {
                File report = ResourceUtils.getFile("classpath:sales.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(report.getAbsolutePath());

                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(salesList);

                Map<String, Object> parameters = new HashMap<>();
                parameters.put("Created with", "Jasper Report");

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\sales.pdf");
            }

            if (reportFormat.equalsIgnoreCase("excel")) {
                try (Workbook workbook = new XSSFWorkbook()) {
                    File report = new File(path);
                    Sheet sheet = workbook.createSheet("Report");

                    Row headerRow = sheet.createRow(0);
                    Cell headerCell = null;
                    for (int i = 0; i < salesList.get(0).getClass().getDeclaredFields().length; i++) {
                        headerCell = headerRow.createCell(i);
                        headerCell.setCellValue(salesList.get(0).getClass().getDeclaredFields()[i].getName());
                    }

                    int rowCount = 1;
                    for (SalesModel sales : salesList) {
                        Row row = sheet.createRow(rowCount++);
                        Cell cell = null;
                        for (int i = 0; i < sales.getClass().getDeclaredFields().length; i++) {
                            cell = row.createCell(i);
                            cell.setCellValue((Double) sales.getClass().getDeclaredFields()[i].get(sales));
                        }
                    }

                    try (FileOutputStream outputStream = new FileOutputStream(report)) {
                        workbook.write(outputStream);
                    }
                }
            }
        }
        return "Invalid Path";
    }
}
