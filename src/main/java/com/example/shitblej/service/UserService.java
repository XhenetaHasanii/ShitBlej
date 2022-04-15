package com.example.shitblej.service;

import com.example.shitblej.model.User;
import com.example.shitblej.repository.AdvertisementRepository;
import com.example.shitblej.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final AdvertisementRepository advertisementRepository;

  @Autowired
  public UserService(UserRepository userRepository,
      AdvertisementRepository advertisementRepository) {
    this.userRepository = userRepository;
    this.advertisementRepository = advertisementRepository;
  }


  public boolean userEmailExists(String email) {
    List<User> userList = userRepository.findByEmail(email);
    if (userList == null || userList.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  public User getUser(Long id) {
    User user = userRepository.findById(id).orElse(null);
    if (user == null) {
      return null;
    }
    user.setPassword("******");
    return user;
  }

  public User create(User usr) {
      User createdUser = userRepository.save(usr);
      createdUser.setPassword("******");
      return createdUser;
  }
}
