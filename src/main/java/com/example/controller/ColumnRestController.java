package com.example.controller;

import com.example.model.Column;
import com.example.service.ColumnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/")
public class ColumnRestController {

  private final ColumnService columnService;

  public ColumnRestController(ColumnService columnService) {
    this.columnService = columnService;
  }

  @GetMapping(value = "")
  public ResponseEntity<List<Column>> getAllCustomers() {
    List<Column> customers = columnService.getAll();

    if (customers.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(customers, HttpStatus.OK);
  }

  @PostMapping(value = "")
  public ResponseEntity<?> createColumn(@RequestBody Column column){
    if (column == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    columnService.create(column);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/{name}")
  public ResponseEntity<?> changeColumnName(@RequestBody Column column, @PathVariable(name = "name") String name) {
    if (column == null || name == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    columnService.changeName(column, name);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "")
  public ResponseEntity<?> delete(@RequestBody Column column) {
    if (column == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    columnService.delete(column);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
