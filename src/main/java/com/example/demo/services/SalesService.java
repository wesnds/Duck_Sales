package com.example.demo.services;

import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.DuckRepository;
import com.example.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DuckRepository duckRepository;

//    public SalesModel registerSale(Long duckId, Long customerId) {
//        DuckModel duck = ""; // buscar pato pelo ID
//        CustomerModel customer = "";// buscar cliente pelo ID
//        double price = calculatePrice(duck);
//        double discount = customer.isEligibleForDiscount() ? price * 0.2 : 0;
//        double totalPrice = price - discount;
//
//        SalesModel sale = new SalesModel();
//        sale.setDuck(duck);
//        sale.setCustomer(customer);
//        sale.setSaleDate(LocalDate.now());
//        sale.setTotalPrice(totalPrice);
//
//        return saleRepository.save(sale);
//    }
//
//    private double calculatePrice(DuckModel duck) {
//        // lógica de preço baseada nos requisitos
//    }
}
