package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ducks")
public class DuckModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String motherName;
}
