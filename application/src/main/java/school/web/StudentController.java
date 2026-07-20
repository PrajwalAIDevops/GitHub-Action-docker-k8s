package school.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import school.domain.Student;
import school.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping
  public String list(Model model) {
    List<Student> students = service.listAll();
    model.addAttribute("students", students);
    return "students";
  }

  @PostMapping
  public String create(
      @RequestParam String name,
      @RequestParam int grade,
      RedirectAttributes redirectAttributes
  ) {
    try {
      service.create(name, grade);
      redirectAttributes.addFlashAttribute("message", "Student created successfully");
    } catch (IllegalArgumentException e) {
      redirectAttributes.addFlashAttribute("error", e.getMessage());
    }
    return "redirect:/students";
  }
}

