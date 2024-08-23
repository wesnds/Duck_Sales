package com.example.demo.controllers;

import com.example.demo.entities.ResultObj;
import com.example.demo.models.DuckModel;
import com.example.demo.models.SalesModel;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.services.SalesService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SalesController {

    @Autowired
    private SalesService saleService;

    @PostMapping("/sales")
    public SalesModel createSale(@RequestBody @NotNull Map<String, Object> requestBody) {
        Long customerId = (Long) requestBody.get("customerId");
        List<DuckModel> ducks = (List<DuckModel>) requestBody.get("ducks");

        return saleService.createSale(customerId, ducks);
    }


    @GetMapping("/sales")
    public ResponseEntity<List<SalesModel>> getAllSales() {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAllSales());
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> getDuckById(
            @PathVariable(value="id")
            Long id
    ){
        ResultObj resultObj = saleService.getSaleById(id);
        if(resultObj.getStatus().equals("Sale " + id)){
            return ResponseEntity.status(HttpStatus.CREATED).body(resultObj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultObj);
    }
}
