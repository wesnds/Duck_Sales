package com.example.demo.repositories;

import com.example.demo.models.DuckModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckRepository extends JpaRepository<DuckModel, Long> {
}
