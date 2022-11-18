package com.example.service;

import java.util.List;

import com.example.model.Column;
import com.example.repository.ColumnRepository;
import org.springframework.stereotype.Service;

@Service
public class ColumnServiceImpl implements ColumnService {

  private final ColumnRepository columnRepository;

  public ColumnServiceImpl(ColumnRepository columnRepository) {
    this.columnRepository = columnRepository;
  }

  @Override
  public void create(Column column) {
    columnRepository.save(column);
  }

  @Override
  public List<Column> getAll() {
    return columnRepository.findAll();
  }

  @Override
  public void changeName(Column column, String name) {
    column.setName(name);
    columnRepository.save(column);
  }

  @Override
  public void delete(Column column) {
    columnRepository.delete(column);
  }

  @Override
  public void changeOrder(int currentSequenceNumber, int newSequenceNumber) {

  }
}
