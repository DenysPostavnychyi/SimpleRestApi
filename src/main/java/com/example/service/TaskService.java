package com.example.service;

import java.util.List;

import com.example.model.Task;

public interface TaskService {
  void add(Task task);

  List<Task> getAll();

  void edit(Long id, Task task);

  void delete(Task task);
}
