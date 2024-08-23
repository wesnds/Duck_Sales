package com.example.demo.services;

import com.example.demo.entities.ResultObj;
import com.example.demo.models.CustomerModel;
import com.example.demo.models.DuckModel;
import com.example.demo.models.SalesModel;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DuckService duckService;

    public SalesModel createSale(Long customerId, List<DuckModel> ducks){
        CustomerModel customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        double totalSaleValue = calculateTotalSaleValue(ducks);
        double discountedTotal = applyDiscount(totalSaleValue, customer.isEligibleForDiscount());

        SalesModel sale = new SalesModel();
        sale.setTotalPrice(discountedTotal);
        sale.setCustomer(customer);
        sale.setSaleDate(new Date());

        sale.setDucks(ducks);
        return saleRepository.save(sale);
    }

    private double calculateTotalSaleValue(List<DuckModel> ducks) {
        return ducks.stream().mapToDouble(DuckModel::getPrice).sum();
    }

    private double applyDiscount(double totalSaleValue, boolean isEligibleForDiscount) {
        if (isEligibleForDiscount) {
            return totalSaleValue * 0.8;
        } else {
            return totalSaleValue;
        }
    }

    public List<SalesModel> getAllSales(){
        return saleRepository.findAll();
    }

    public ResultObj getSaleById(Long id){
        ResultObj resultObj = new ResultObj();
        Optional<SalesModel> salesO = saleRepository.findById(id);

        if(salesO.isEmpty()){
            resultObj.setStatus("Sale not found");
            return resultObj;
        }

        resultObj.setStatus("Sale " + id);
        resultObj.setObj(salesO);

        return resultObj;
    }
}
