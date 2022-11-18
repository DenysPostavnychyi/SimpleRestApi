package com.example.controller;

import java.util.List;

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
@RequestMapping("/board/column/")
public class TaskRestController {

  private final TaskService taskService;

  public TaskRestController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping(value = "")
  public ResponseEntity<List<Task>> getAllTasks() {
    List<Task> tasks = taskService.getAll();

    if (tasks.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  @PostMapping(value = "")
  public ResponseEntity<?> addTask(@RequestBody Task task) {
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    taskService.add(task);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> editTaskById(@RequestBody Task task,
                                        @PathVariable(name = "id") Long id) {
    if (task == null || id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    taskService.edit(id, task);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "")
  public ResponseEntity<?> delete(@RequestBody Task task) {
    if (task == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    taskService.delete(task);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
