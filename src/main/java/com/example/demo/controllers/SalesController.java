package com.example.demo.controllers;

import com.example.demo.models.SalesModel;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {

    @Autowired
    private SalesService saleService;

//    @PostMapping
//    public ResponseEntity<SalesModel> registerSale(@RequestParam Long duckId, @RequestParam Long customerId) {
//        SalesModel sale = saleService.registerSale(duckId, customerId);
//        return ResponseEntity.ok(sale);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<SalesModel>> getAllSales() {
//        List<SalesModel> sales = saleService.findAllSales();
//        return ResponseEntity.ok(sales);
//    }
}
