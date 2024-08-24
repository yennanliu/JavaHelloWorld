package com.yen.workspace.model;

public class Report {

    private Integer id;
    private TestResult[] results;

    public Report(){

    }

    public Report(Integer id, TestResult[] results) {
        this.id = id;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TestResult[] getResults() {
        return results;
    }

    public void setResults(TestResult[] results) {
        this.results = results;
    }

}
