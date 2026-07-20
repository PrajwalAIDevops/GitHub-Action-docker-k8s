package school.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.domain.Course;
import school.repo.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
  private final CourseRepository repo;

  public CourseService(CourseRepository repo) {
    this.repo = repo;
  }

  public List<Course> listAll() {
    return repo.findAll();
  }

  public Optional<Course> getById(long id) {
    return repo.findById(id);
  }

  @Transactional
  public Course create(String title, int credit) {
    validate(title, credit);
    return repo.save(new Course(title.trim(), credit));
  }

  @Transactional
  public Course update(long id, String title, int credit) {
    validate(title, credit);
    Course existing = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Course not found: " + id));
    existing.setTitle(title.trim());
    existing.setCredit(credit);
    return existing;
  }

  private void validate(String title, int credit) {
    if (title == null || title.trim().isEmpty()) {
      throw new IllegalArgumentException("Title is required");
    }
    if (credit < 1 || credit > 10) {
      throw new IllegalArgumentException("Credit must be between 1 and 10");
    }
  }
}

