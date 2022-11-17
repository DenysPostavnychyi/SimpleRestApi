package com.example.repository;

import com.example.model.Column;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Column, Integer> {
  boolean delete(Integer sequenceNumber);
}
