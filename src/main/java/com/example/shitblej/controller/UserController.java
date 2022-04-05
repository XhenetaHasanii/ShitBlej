package com.example.shitblej.controller;

import com.example.shitblej.model.User;
import com.example.shitblej.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> postUser(@RequestBody User userRequest) {

    if (userService.userEmailExists(userRequest.getEmail())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("User with the same Email already exists");
    }

    User userResponse = userService.create(new User(userRequest.getEmail(),userRequest.getPassword(),userRequest.getFirstName(),
        userRequest.getLastName(), userRequest.getPhone(), userRequest.getLocation()));
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }


  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getUser(@PathVariable final Long id) {
    if (id < 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }

    User user = userService.getUser(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no data");
    }

    return ResponseEntity.status(HttpStatus.OK).body(user);
  }
}
