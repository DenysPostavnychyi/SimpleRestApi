package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public void add(Task task) {
    taskRepository.save(task);
  }

  @Override
  public List<Task> getAll() {
    return taskRepository.findAll();
  }

  @Override
  public void edit(Long id, Task task) {
    taskRepository.deleteById(id);
    taskRepository.save(task);
  }

  @Override
  public void delete(Task task) {
    taskRepository.delete(task);
  }
}
