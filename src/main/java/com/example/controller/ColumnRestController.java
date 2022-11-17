package com.example.controller;

import com.example.model.Column;
import com.example.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ColumnRestController {

  @Autowired
  private ColumnService columnService;

  @RequestMapping(value = "/columns")
  public ResponseEntity<?> create(@RequestBody Column column){
    columnService.create(column);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/columns/{id}")
  public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody String name) {
    final boolean updated = columnService.changeName(id, name);

    return updated
        ? new ResponseEntity<>(HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
  }

  @DeleteMapping(value = "/columns/{id}")
  public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
    final boolean deleted = columnService.delete(id);

    return deleted
        ? new ResponseEntity<>(HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
  }
}
