package com.example.controller;

import java.util.List;

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
  public ResponseEntity<List<Column>> getAllColumns() {
    List<Column> columns = columnService.getAll();

    if (columns.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(columns, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Column> getColumnById(@PathVariable(name = "id") Long id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Column column = columnService.getById(id);
    return new ResponseEntity<>(column, HttpStatus.OK);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<?> createColumn(@RequestBody Column column) {
    if (column == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    columnService.create(column);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/newName/{name}")
  public ResponseEntity<?> changeColumnName(@RequestBody Column column,
                                            @PathVariable(name = "name") String name) {
    if (column == null || name == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    columnService.changeName(column, name);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping(value = "/newSequenceNumber/{num}")
  public ResponseEntity<?> changeColumnSequenceNumber(@RequestBody Column column,
                                                      @PathVariable(name = "num") Integer num) {
    if (column == null || num == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    columnService.changeSequenceNumber(column, num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete")
  public ResponseEntity<?> delete(@RequestBody Column column) {
    if (column == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    columnService.delete(column);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
