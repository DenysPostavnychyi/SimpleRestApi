package com.example.service;

import java.util.List;

import com.example.model.Task;

public interface TaskService {
  void add(Task task);

  Task getById(Long id);

  List<Task> getAll();

  void edit(Task task);

  void changeColumn(Task task, int columnNumber);

  void changeSequenceNumber(Task task, int sequenceNumber);

  void delete(Task task);
}
