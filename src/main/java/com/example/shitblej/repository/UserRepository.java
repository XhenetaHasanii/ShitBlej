package com.example.shitblej.repository;

import com.example.shitblej.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByEmail(String email);
}
