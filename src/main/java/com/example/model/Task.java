package com.example.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @javax.persistence.Column(name = "id")
  private Long id;

  @javax.persistence.Column(name = "name")
  private String name;

  @javax.persistence.Column(name = "description")
  private String description;

  @javax.persistence.Column(name = "date_of_creation")
  private LocalDate dateOfCreation;

  @javax.persistence.Column(name = "sequence_number")
  private int sequenceNumber;

  @javax.persistence.Column(name = "column_id")
  private int columnNumber;
}
