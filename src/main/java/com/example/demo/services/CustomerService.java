package com.example.demo.services;

import com.example.demo.DTOs.CustomerRecordDto;
import com.example.demo.entities.ResultObj;
import com.example.demo.models.CustomerModel;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerModel registerCustomer(CustomerRecordDto customerRecordDto){
        CustomerModel customerModel = new CustomerModel();

        BeanUtils.copyProperties(customerRecordDto, customerModel);
        return customerRepository.save(customerModel);
    }

    public List<CustomerModel> getAllCustomers(){
        return customerRepository.findAll();
    }

    public ResultObj getCustomerById(Long id){
       ResultObj resultObj = new ResultObj();
       Optional<CustomerModel> customerO = customerRepository.findById(id);

       if(customerO.isEmpty()){
           resultObj.setStatus("Customer not found");
           return resultObj;
       }

       resultObj.setStatus("Customer created");
       resultObj.setObj(customerO);
       return resultObj;
    }
}
