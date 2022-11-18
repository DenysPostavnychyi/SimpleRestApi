package com.example.service;

import com.example.model.Task;

import java.util.List;

public interface TaskService {
  void add(Task task);

  List<Task> getAll();

  void edit(Long id, Task task);

  void delete(Task task);
}
