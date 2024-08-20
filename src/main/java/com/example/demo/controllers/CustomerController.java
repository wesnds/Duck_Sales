package com.example.demo.controllers;

import com.example.demo.DTOs.CustomerRecordDto;
import com.example.demo.models.CustomerModel;
import com.example.demo.repositories.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<CustomerModel> saveCustomer(@RequestBody @Valid CustomerRecordDto customerRecordDto){
        var customerModel = new CustomerModel();
        BeanUtils.copyProperties(customerRecordDto, customerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.save(customerModel));
    }
}
