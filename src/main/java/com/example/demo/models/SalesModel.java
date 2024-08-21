package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="sales")
public class SalesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private DuckModel duck;
    @ManyToOne
    private CustomerModel customer;
    private LocalDate saleDate;
    private double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DuckModel getDuck() {
        return duck;
    }

    public void setDuck(DuckModel duck) {
        this.duck = duck;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public LocalDate getSaleDate() {
        return LocalDate.now();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
