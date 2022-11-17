package com.example.service;

import com.example.model.Column;
import com.example.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnServiceImpl implements ColumnService {

  @Autowired
  ColumnRepository columnRepository;

  @Override
  public void create(Column column) {
    columnRepository.save(column);
  }

  @Override
  public boolean changeName(int sequenceNumber, String name) {
    return true;
  }

  @Override
  public boolean delete(Integer sequenceNumber) {
    return columnRepository.delete(sequenceNumber);
  }

  @Override
  public void changeOrder(int currentSequenceNumber, int newSequenceNumber) {

  }
}
