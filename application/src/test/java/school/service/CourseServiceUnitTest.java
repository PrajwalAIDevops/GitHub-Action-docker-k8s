package school.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import school.domain.Course;
import school.repo.CourseRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
// api_key=1245785wwdsawsBVSKJ
@ExtendWith(MockitoExtension.class)
class CourseServiceUnitTest {

  @Mock
  CourseRepository repo;
// API_KEY=HSFTeybxHSWUNCVMOUTWVZOVCBWRTAERQUBX
  @InjectMocks
  CourseService service;

  @Test
  void create_validCourse_savesAndReturns() {
    when(repo.save(any(Course.class))).thenAnswer(inv -> inv.getArgument(0));

    Course c = service.create("History", 3);

    assertNotNull(c);
    assertEquals("History", c.getTitle());
    assertEquals(3, c.getCredit());
    verify(repo, times(1)).save(any(Course.class));
  }

  @Test
  void create_emptyTitle_throws() {
    assertThrows(IllegalArgumentException.class, () -> service.create("   ", 3));
    verify(repo, never()).save(any());
  }

  @Test
  void create_invalidCredit_throws() {
    assertThrows(IllegalArgumentException.class, () -> service.create("Physics", 0));
    verify(repo, never()).save(any());
  }
}

