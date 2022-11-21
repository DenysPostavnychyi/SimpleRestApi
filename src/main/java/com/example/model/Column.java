package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "columns")
public class Column {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @javax.persistence.Column(name = "id")
  private Long id;

  @javax.persistence.Column(name = "name")
  private String name;

  @javax.persistence.Column(name = "sequence_number")
  private int sequenceNumber;

  @OneToMany
  @JoinColumn(name = "column_id")
  @OrderBy(value = "sequenceNumber")
  private List<Task> tasks;
}
