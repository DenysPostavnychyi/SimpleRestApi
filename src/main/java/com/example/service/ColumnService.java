package com.example.service;

import com.example.model.Column;

import java.util.List;

public interface ColumnService {
  void create(Column column);

  List<Column> getAll();

  void changeName(Column column, String name);

  void delete(Column column);

  void changeOrder(int currentSequenceNumber, int newSequenceNumber);
}
