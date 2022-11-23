package com.example.controller;

import java.util.List;

import com.example.exceptions.BadRequestException;
import com.example.exceptions.NotFoundException;
import com.example.model.Column;
import com.example.service.ColumnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/columns")
public class ColumnRestController {
  private final ColumnService columnService;

  public ColumnRestController(ColumnService columnService) {
    this.columnService = columnService;
  }

  @GetMapping(value = "")
  public ResponseEntity<List<Column>> findAllColumns() throws NotFoundException {
    List<Column> columns = columnService.findAll();

    if (columns.isEmpty()) {
      throw new NotFoundException("Database don`t contains columns");
    }

    return new ResponseEntity<>(columns, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Column> findColumnById(@PathVariable(name = "id") Long id)
      throws BadRequestException, NotFoundException {
    if (id == null || id == 0) {
      throw new BadRequestException("Invalid ID");
    }

    Column column = columnService.findById(id);
    return new ResponseEntity<>(column, HttpStatus.FOUND);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<?> createColumn(@RequestBody Column column)
      throws BadRequestException {
    if (column == null) {
      throw new BadRequestException("Column from request body not found");
    }

    columnService.create(column);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/newName/{name}")
  public ResponseEntity<?> changeColumnName(@RequestBody Column column,
                                            @PathVariable(name = "name") String name)
      throws BadRequestException {
    if (column == null) {
      throw new BadRequestException("Column from request body not found");
    }
    if (name == null || name.trim().isEmpty()) {
      throw new BadRequestException("Invalid name");
    }

    columnService.changeName(column, name);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping(value = "/newSequenceNumber/{num}")
  public ResponseEntity<?> changeColumnSequenceNumber(@RequestBody Column column,
                                                      @PathVariable(name = "num") Integer num)
      throws BadRequestException {
    if (column == null) {
      throw new BadRequestException("Column from request body not found");
    }
    if (num == null || num == 0) {
      throw new BadRequestException("Invalid sequence number");
    }

    columnService.changeSequenceNumber(column.getId(), num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete")
  public ResponseEntity<?> delete(@RequestBody Column column) throws BadRequestException {

    if (column == null) {
      throw new BadRequestException("Column from request body not found");
    }

    columnService.delete(column);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
