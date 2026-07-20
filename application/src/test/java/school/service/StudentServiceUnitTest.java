package school.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import school.domain.Student;
import school.repo.StudentRepository;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceUnitTest {

  @Mock
  StudentRepository repo;

  @InjectMocks
  StudentService service;

  @Test
  void create_validStudent_savesAndReturns() {
    when(repo.save(any(Student.class))).thenAnswer(inv -> inv.getArgument(0));

    Student created = service.create("Charlie", 10);

    assertNotNull(created);
    assertEquals("Charlie", created.getName());
    assertEquals(10, created.getGrade());
    verify(repo, times(1)).save(any(Student.class));
  }

  @Test
  void create_emptyName_throws() {
    assertThrows(IllegalArgumentException.class, () -> service.create("  ", 5));
    verify(repo, never()).save(any());
  }

  @Test
  void create_invalidGrade_throws() {
    assertThrows(IllegalArgumentException.class, () -> service.create("Dave", 0));
    verify(repo, never()).save(any());
  }

  @Test
  void update_whenNotFound_throws() {
    when(repo.findById(99L)).thenReturn(Optional.empty());

    assertThrows(IllegalArgumentException.class, () -> service.update(99L, "Eve", 6));
  }

  @Test
  void listAll_returnsRepoFindAll() {
    when(repo.findAll()).thenReturn(Collections.emptyList());
    assertTrue(service.listAll().isEmpty());
  }
}

