package com.example.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
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

  @javax.persistence.Column(name = "sequence_number", columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private int sequenceNumber;

  @OneToMany
  @JoinColumn(name = "column_id")
  @OrderBy(value = "sequenceNumber")
  private List<Task> tasks;
}
