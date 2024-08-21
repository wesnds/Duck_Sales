package com.example.demo.models;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean eligibleForDiscount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEligibleForDiscount() {
        return eligibleForDiscount;
    }

    public void setEligibleForDiscount(boolean eligibleForDiscount) {
        this.eligibleForDiscount = eligibleForDiscount;
    }
}
