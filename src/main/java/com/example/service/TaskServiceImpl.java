package com.example.service;

import com.example.exceptions.NotFoundException;
import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
  public Task findById(Long id) throws NotFoundException {
    Optional<Task> optionalTask = taskRepository.findById(id);
    return optionalTask.orElseThrow(
        () -> new NotFoundException("Don`t find task by id " + id));
  }

  @Override
  public List<Task> findAll() {
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
