package school.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import school.service.CourseService;
import school.service.StudentService;

@Configuration
public class DataSeeder {

  @Bean
  CommandLineRunner seed(StudentService studentService, CourseService courseService) {
    return args -> {
      // Seed only if empty (service uses repository findAll in integration tests)
      try {
        if (studentService.listAll().isEmpty()) {
          studentService.create("Alice", 5);
          studentService.create("Bob", 7);
        }
        if (courseService.listAll().isEmpty()) {
          courseService.create("Math", 3);
          courseService.create("Science", 4);
        }
      } catch (Exception ignored) {
        // keep startup robust
      }
    };
  }
}

