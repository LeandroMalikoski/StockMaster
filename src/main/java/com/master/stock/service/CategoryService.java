package com.master.stock.service;

import com.master.stock.dto.CategoryRegisterDTO;
import com.master.stock.model.Category;
import com.master.stock.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category registerCategory(CategoryRegisterDTO dto) {
        if (categoryRepository.existsByName(dto.name())){
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category(dto);
        categoryRepository.save(category);
        return category;
    }
}
