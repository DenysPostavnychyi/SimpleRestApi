package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
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

  @OneToMany(mappedBy = "column")
  @JsonManagedReference
  private List<Task> tasks;
}
