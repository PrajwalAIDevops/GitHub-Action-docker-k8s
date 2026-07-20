package school.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerIntegrationTest {

  @Autowired
  MockMvc mvc;

  @Test
  void getCourses_rendersPage() throws Exception {
    mvc.perform(get("/courses"))
        .andExpect(status().isOk())
        .andExpect(view().name("courses"))
        .andExpect(model().attributeExists("courses"));
  }

  @Test
  void postCourses_valid_createsAndRedirects() throws Exception {
    mvc.perform(post("/courses")
            .param("title", "Art")
            .param("credit", "2"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/courses"));
  }

  @Test
  void postCourses_invalid_showsValidationErrorFlash() throws Exception {
    mvc.perform(post("/courses")
            .param("title", "Chemistry")
            .param("credit", "0"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/courses"));
  }
}

