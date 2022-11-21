package com.example.service;

import java.util.List;

import com.example.model.Column;

public interface ColumnService {
  void create(Column column);

  Column getById(Long id);

  List<Column> getAll();

  void changeName(Column column, String name);

  void changeSequenceNumber(Column column, int sequenceNumber);

  void delete(Column column);
}
