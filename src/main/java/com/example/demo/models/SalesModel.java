package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="sales")
public class SalesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<DuckModel> ducks;
    @ManyToOne
    private CustomerModel customer;
    private double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DuckModel> getDucks() {
        return ducks;
    }

    public void setDucks(List<DuckModel> ducks) {
        this.ducks = ducks;
    }

    public void setSaleDate(Date saleDate) {
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
