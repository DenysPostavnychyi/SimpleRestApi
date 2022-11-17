package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "columns")
public class Column {
  private static int count = 0;

  @javax.persistence.Column(name = "sequenceNumber")
  private int sequenceNumber;

  @javax.persistence.Column(name = "name")
  private String name;

  public Column(String name) {
    this.name = name;
    sequenceNumber = ++count;
  }
}
