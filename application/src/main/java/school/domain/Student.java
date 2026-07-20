package school.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private int grade;

  protected Student() {
    // for JPA
  }

  public Student(String name, int grade) {
    this.name = name;
    this.grade = grade;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getGrade() {
    return grade;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }
}

