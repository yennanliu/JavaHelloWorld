package com.yen.workspace.model;

import java.util.List;

public class Report {

  private Integer id;
  private List<TestResult> results;

  public Report() {}

  public Report(Integer id, List<TestResult> results) {
    this.id = id;
    this.results = results;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<TestResult> getResults() {
    return results;
  }

  public void setResults(List<TestResult> results) {
    this.results = results;
  }

  @Override
  public String toString() {
    return "Report{" + "id=" + id + ", results=" + results + '}';
  }
}
