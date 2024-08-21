package com.example.demo.controllers;

import com.example.demo.DTOs.CustomerRecordDto;
import com.example.demo.entities.ResultObj;
import com.example.demo.models.CustomerModel;
import com.example.demo.models.DuckModel;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<CustomerModel> registerCustomer(@RequestBody @Valid CustomerRecordDto customerRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(customerRecordDto));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getDuckById(
            @PathVariable(value="id")
            Long id
    ){
        ResultObj resultObj = customerService.getCustomerById(id);
        if(resultObj.getStatus().equals("Duck saved")){
            return ResponseEntity.status(HttpStatus.CREATED).body(resultObj);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultObj);
    }
}
