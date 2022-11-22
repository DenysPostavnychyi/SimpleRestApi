package com.example.service;

import java.util.List;

import com.example.exceptions.NotFoundException;
import com.example.model.Column;

public interface ColumnService {
  void create(Column column);

  Column findById(Long id) throws NotFoundException;

  List<Column> findAll();

  void changeName(Column column, String name);

  void changeSequenceNumber(Column column, int sequenceNumber);

  void delete(Column column);
}
