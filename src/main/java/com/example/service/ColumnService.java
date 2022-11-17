package com.example.service;

import com.example.model.Column;

public interface ColumnService {
  void create(Column column);

  boolean changeName(int sequenceNumber, String name);

  boolean delete(Integer sequenceNumber);

  void changeOrder(int currentSequenceNumber, int newSequenceNumber);
}
