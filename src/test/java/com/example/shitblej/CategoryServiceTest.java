package com.example.shitblej;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.example.shitblej.model.Category;
import com.example.shitblej.repository.CategoryRepository;
import com.example.shitblej.service.CategoryService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
  @Mock
  private CategoryRepository categoryRepository;

  @InjectMocks
  private CategoryService categoryService;

  @Test
  void categoryNameExists_nameExists() {
    Category parent = new Category("parentCategory");
    Category category1 = new Category("childCategory1");
    Category category2 = new Category("childCategory1");

    Mockito.when(categoryRepository.findByName(Mockito.anyString()))
        .thenReturn(List.of(category1, category2));

    assertTrue(categoryService.categoryNameExists("childCategory1"));
  }

  @Test
  void categoryNameExists_nameNotFound() {
    Category parent = new Category("parentCategory");
    Category category1 = new Category("childCategory1");

    Mockito.when(categoryRepository.findByName(Mockito.anyString())).thenReturn(List.of());

    assertFalse(categoryService.categoryNameExists("childCategory2"));
  }

}
