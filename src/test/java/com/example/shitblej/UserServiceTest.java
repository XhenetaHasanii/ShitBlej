package com.example.shitblej;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import com.example.shitblej.model.User;
import com.example.shitblej.repository.UserRepository;
import com.example.shitblej.service.UserService;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @Test
  void userEmailExistsIsTrue() {
    User usr = new User("test", "test", "test", "test", "test", "test");
    User usr2 = new User("test2", "test2", "test2", "test2", "test2", "test2");
    Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(List.of(usr, usr2));
    assertTrue(userService.userEmailExists("test"));
  }

  @Test
  void userEmailDoesNotExist() {
    User usr = new User("test", "test", "test", "test", "test", "test");
    Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(List.of());
    assertFalse(userService.userEmailExists("test3"));
  }

  @Test
  void create_userIsCreated() {
    User userRequest = new User();
    userRequest.setLocation("testDA");
    userRequest.setEmail("testEmail");
    userRequest.setPassword("testpwd");
    userRequest.setFirstName("testFirstName");
    userRequest.setLastName("testLastName");
    userRequest.setPhone("testPhoneNumber");

    Mockito.when(userRepository.save(any(User.class))).thenReturn(userRequest);

    assertEquals(userRequest.getEmail(), userService.create(userRequest).getEmail());
    assertEquals(userRequest.getFirstName(), userService.create(userRequest).getFirstName());

  }

}
