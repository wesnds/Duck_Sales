package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private DuckModel duck;
    @ManyToOne
    private CustomerModel customer;
    private LocalDate saleDate;
    private double totalPrice;
}
