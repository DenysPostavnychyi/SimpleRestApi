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
  public Task getById(Long id) {
    return taskRepository.findById(id).get();
  }

  @Override
  public List<Task> getAll() {
    return taskRepository.findAllByOrderBySequenceNumber();
  }

  @Override
  public void edit(Task task) {
    taskRepository.deleteById(task.getId());
    taskRepository.save(task);
  }

  @Override
  public void changeColumn(Task task, int columnNumber) {
    Task taskWithNewColumnNumber = task;
    taskWithNewColumnNumber.setColumnNumber(columnNumber);
    edit(taskWithNewColumnNumber);
  }

  @Override
  public void changeSequenceNumber(Task task, int sequenceNumber) {
    taskRepository.changeSequenceNumber(sequenceNumber, task.getId());
  }

  @Override
  public void delete(Task task) {
    taskRepository.delete(task);
  }
}
