package com.backend.gestion_eventos.services;

import com.backend.gestion_eventos.models.Category;
import com.backend.gestion_eventos.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category save(Category category) {
        Category newCategory = Category.builder()
                .name(category.getName())
                .build();
        return categoryRepository.save(newCategory);
    }
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Transactional
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
