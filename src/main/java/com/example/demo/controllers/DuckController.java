package com.example.demo.controllers;

import com.example.demo.DTOs.DuckRecordDto;
import com.example.demo.entities.ResultObj;
import com.example.demo.models.DuckModel;
import com.example.demo.repositories.DuckRepository;
import com.example.demo.services.DuckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuckController {
    @Autowired
    DuckRepository duckRepository;

    @Autowired
    DuckService duckService;

    @PostMapping("/ducks")
    public ResponseEntity<ResultObj> registerDuck(@RequestBody @Valid DuckRecordDto duckRecordDto){
        ResultObj resultObj = duckService.registerDuck(duckRecordDto);
        if(resultObj.getStatus().equals("Duck saved")){
            return ResponseEntity.status(HttpStatus.CREATED).body(resultObj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultObj);
    }

    @GetMapping("/ducks")
    public ResponseEntity<List<DuckModel>> getAllDucks() {
        return ResponseEntity.status(HttpStatus.OK).body(duckService.getAllDucks());
    }

    @GetMapping("/ducks/{id}")
    public ResponseEntity<Object> getDuckById(
            @PathVariable(value="id")
            Long id
    ){
        ResultObj resultObj = duckService.getDuckById(id);
        if(resultObj.getStatus().equals("Duck saved")){
            return ResponseEntity.status(HttpStatus.CREATED).body(resultObj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultObj);
    }
}
