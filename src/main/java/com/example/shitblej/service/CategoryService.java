package com.example.shitblej.service;

import com.example.shitblej.model.Category;
import com.example.shitblej.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category create(Category categoryCreate) {
      return categoryRepository.save(categoryCreate);
  }

  public Category getCategory(Long id) {
    Category cat = categoryRepository.findById(id).orElse(null);
    if (cat == null) {
      return null;
    }
    return cat;
  }

  public boolean categoryNameExists(String name) {
    List<Category> categories = categoryRepository.findByName(name);
    if (categories == null || categories.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

}
