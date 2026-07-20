package school.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import school.domain.Course;
import school.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

  private final CourseService service;

  public CourseController(CourseService service) {
    this.service = service;
  }

  @GetMapping
  public String list(Model model) {
    List<Course> courses = service.listAll();
    model.addAttribute("courses", courses);
    return "courses";
  }

  @PostMapping
  public String create(
      @RequestParam String title,
      @RequestParam int credit,
      RedirectAttributes redirectAttributes
  ) {
    try {
      service.create(title, credit);
      redirectAttributes.addFlashAttribute("message", "Course created successfully");
    } catch (IllegalArgumentException e) {
      redirectAttributes.addFlashAttribute("error", e.getMessage());
    }
    return "redirect:/courses";
  }
}

