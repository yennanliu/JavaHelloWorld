package com.yen.workspace.model;

import java.util.Date;

// data model for report
public class TestResult {
  private Integer id;
  private String serialNum;
  private String status;
  private Date createTime;

  public TestResult() {}

  public TestResult(Integer id, String serialNum, String status, Date createTime) {
    this.id = id;
    this.serialNum = serialNum;
    this.status = status;
    this.createTime = createTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSerialNum() {
    return serialNum;
  }

  public void setSerialNum(String serialNum) {
    this.serialNum = serialNum;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "TestResult{"
        + "id="
        + id
        + ", serialNum='"
        + serialNum
        + '\''
        + ", status='"
        + status
        + '\''
        + ", createTime="
        + createTime
        + '}';
  }
}
