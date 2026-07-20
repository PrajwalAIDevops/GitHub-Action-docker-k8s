package school.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  private int credit;

  protected Course() {
    // for JPA
  }

  public Course(String title, int credit) {
    this.title = title;
    this.credit = credit;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getCredit() {
    return credit;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }
}

