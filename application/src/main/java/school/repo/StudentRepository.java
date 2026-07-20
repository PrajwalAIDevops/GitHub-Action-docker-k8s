package school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import school.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

