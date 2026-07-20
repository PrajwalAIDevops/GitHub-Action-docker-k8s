package school.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

  @Autowired
  MockMvc mvc;

  @Test
  void getStudents_rendersPage() throws Exception {
    mvc.perform(get("/students"))
        .andExpect(status().isOk())
        .andExpect(view().name("students"))
        .andExpect(model().attributeExists("students"));
  }

  @Test
  void postStudents_valid_createsAndRedirects() throws Exception {
    mvc.perform(post("/students")
            .param("name", "Zara")
            .param("grade", "8"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/students"));
  }

  @Test
  void postStudents_invalid_showsErrorFlash() throws Exception {
    mvc.perform(post("/students")
            .param("name", "Mike")
            .param("grade", "15"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/students"));
  }
}

