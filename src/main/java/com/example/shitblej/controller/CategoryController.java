package com.example.shitblej.controller;

import com.example.shitblej.model.Category;
import com.example.shitblej.service.CategoryService;
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
@RequestMapping("/api/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> postCategory(@RequestBody Category categoryRequest) {

    if (categoryService.categoryNameExists(categoryRequest.getName())){
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Category with the same name already exists");
    }

    try {
      Category category = categoryService.create(new Category(categoryRequest.getName()));
      return new ResponseEntity<>(category, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getCategory(@PathVariable final Long id) {
    if (id < 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }
    Category categoryReturn = categoryService.getCategory(id);
    if (categoryReturn == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no data");
    }

    return ResponseEntity.status(HttpStatus.OK).body(categoryReturn);
  }
}
