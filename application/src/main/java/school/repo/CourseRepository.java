package school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import school.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

