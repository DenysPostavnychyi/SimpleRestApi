package com.example.controller;

import java.util.List;

import com.example.exceptions.NotFoundException;
import com.example.model.Task;
import com.example.service.TaskService;
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
@RequestMapping("/tasks")
public class TaskRestController {

  private final TaskService taskService;

  public TaskRestController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping(value = "")
  public ResponseEntity<List<Task>> findAllColumns() {
    List<Task> columns = taskService.findAll();

    if (columns.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(columns, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Task> findColumnById(@PathVariable(name = "id") Long id)
      throws NotFoundException {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Task column = taskService.findById(id);
    return new ResponseEntity<>(column, HttpStatus.OK);
  }

  @PostMapping(value = "/add")
  public ResponseEntity<?> addTask(@RequestBody Task task) {
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    taskService.add(task);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "")
  public ResponseEntity<?> editTask(@RequestBody Task task) {
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    taskService.edit(task);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping(value = "/newColumnNumber/{num}")
  public ResponseEntity<?> changeTaskColumn(@RequestBody Task task,
                                            @PathVariable(name = "num") Integer num) {
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    taskService.changeColumn(task, num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping(value = "/newSequenceNumber/{num}")
  public ResponseEntity<?> changeTaskSequenceNumber(@RequestBody Task task,
                                                    @PathVariable(name = "num") Integer num) {
    if (task == null || num == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    taskService.changeSequenceNumber(task, num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete")
  public ResponseEntity<?> delete(@RequestBody Task task) {
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    taskService.delete(task);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
