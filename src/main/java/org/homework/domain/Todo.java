package org.homework.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Todo {

  private String id;                // 아이디
  private String name;              // 할 일 이름
  private String description;       // 할 일 내용
  private boolean done;            // 완료 여부
  private LocalDate reg_date;       // 등록일
  private LocalDate due_date;       // 마감일


  public Todo() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public LocalDate getReg_date() {
    return reg_date;
  }

  // 등록일 문자열로 반환
  public String getReg_dateString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return reg_date.format(formatter);
  }

  // 마감일 문자열로 반환
  public String getDue_dateString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return due_date.format(formatter);
  }

  public void setReg_date(LocalDate reg_date) {
    this.reg_date = reg_date;
  }

  public LocalDate getDue_date() {
    return due_date;
  }

  public void setDue_date(LocalDate due_date) {
    this.due_date = due_date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    return "id : " + id + "\n"
        + "할 일 이름 : " + name + "\n"
        + "할 일의 내용 : " + description + "\n"
        + "완료 여부 : " + (done ? "[완료]" : "[미완료]") + "\n"
        + "생성일 : " + reg_date.format(formatter) + "\n"
        + "마감일 : " + due_date.format(formatter);
  }
}
