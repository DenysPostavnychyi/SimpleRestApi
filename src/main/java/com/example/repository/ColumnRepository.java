package com.example.repository;

import com.example.model.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<Column, Long> {
  @Modifying
  @Query("UPDATE Column c SET c.name = ?1 WHERE c.id = ?2")
  @Transactional
  void changeName(String name, Long id);

  @Modifying
  @Query("UPDATE Column c SET c.sequenceNumber = ?1 WHERE c.id = ?2")
  @Transactional
  void changeSequenceNumber(Integer sequenceNumber, Long id);

  List<Column> findAllByOrderBySequenceNumber();
}
