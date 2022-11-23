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
  public void changeSequenceNumber(Long idOfColumnForChange, int newSequenceNumber) {
    columnRepository.changeSequenceNumber(newSequenceNumber, idOfColumnForChange);

    if (newSequenceNumber < idOfColumnForChange) {
      List<Column> columns = findAll();
      changeSequenceNumbersByAscending(columns, idOfColumnForChange, newSequenceNumber);
    } else {
      changeSequenceNumbersByDescending(idOfColumnForChange, newSequenceNumber);
    }
  }

  private void changeSequenceNumbersByAscending(List<Column> columns, Long idOfColumnForChange, int newSequenceNumber) {
    int sequenceNumber = newSequenceNumber;

    for (int i = newSequenceNumber - 1; i < idOfColumnForChange - 1; i++) {
      columnRepository.changeSequenceNumber(++sequenceNumber, columns.get(i).getId());
    }
  }

  private void changeSequenceNumbersByDescending(Long idOfColumnForChange, int newSequenceNumber) {
    int sequenceNumber = newSequenceNumber;
    List<Column> columns = findAll();

    for (int i = newSequenceNumber - 2; i >= idOfColumnForChange - 1; i--) {
      columnRepository.changeSequenceNumber(--sequenceNumber, columns.get(i).getId());
    }
  }

  @Override
  public void delete(Column column) {
    columnRepository.delete(column);
  }
}
