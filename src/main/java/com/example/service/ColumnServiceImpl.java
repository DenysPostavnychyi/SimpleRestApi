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
  public Column getById(Long id) {
    return columnRepository.findById(id).get();
  }

  @Override
  public List<Column> getAll() {
    return columnRepository.findAllByOrderBySequenceNumber();
  }

  @Override
  public void changeName(Column column, String name) {
    columnRepository.changeName(name, column.getId());
  }

  @Override
  public void changeSequenceNumber(Column column, int sequenceNumber) {
    columnRepository.changeSequenceNumber(sequenceNumber, column.getId());
  }

  @Override
  public void delete(Column column) {
    columnRepository.delete(column);
  }
}
