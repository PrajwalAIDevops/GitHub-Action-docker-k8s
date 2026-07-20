package school.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.domain.Student;
import school.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
  private final StudentRepository repo;

  public StudentService(StudentRepository repo) {
    this.repo = repo;
  }

  public List<Student> listAll() {
    return repo.findAll();
  }

  public Optional<Student> getById(long id) {
    return repo.findById(id);
  }

  @Transactional
  public Student create(String name, int grade) {
    validate(name, grade);
    return repo.save(new Student(name.trim(), grade));
  }

  @Transactional
  public Student update(long id, String name, int grade) {
    validate(name, grade);
    Student existing = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Student not found: " + id));
    existing.setName(name.trim());
    existing.setGrade(grade);
    return existing;
  }

  private void validate(String name, int grade) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name is required");
    }
    if (grade < 1 || grade > 12) {
      throw new IllegalArgumentException("Grade must be between 1 and 12");
    }
  }
}

