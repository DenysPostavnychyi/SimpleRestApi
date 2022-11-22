package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.exceptions.NotFoundException;
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
  public Column findById(Long id) throws NotFoundException {
    Optional<Column> optionalColumn = columnRepository.findById(id);
    return optionalColumn.orElseThrow(
        () -> new NotFoundException("Don`t find column by id " + id));
  }

  @Override
  public List<Column> findAll() {
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
