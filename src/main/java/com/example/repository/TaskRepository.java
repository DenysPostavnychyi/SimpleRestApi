package com.example.repository;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  @Modifying
  @Query("UPDATE Task t SET t.sequenceNumber = ?1 WHERE t.id = ?2")
  @Transactional
  void changeSequenceNumber(Integer sequenceNumber, Long id);

  List<Task> findAllByOrderBySequenceNumber();
}
