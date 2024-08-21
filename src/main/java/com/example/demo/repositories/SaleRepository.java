package com.example.demo.repositories;

import com.example.demo.models.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SalesModel, Long> {
}
