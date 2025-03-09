package com.master.stock.service;

import com.master.stock.dto.CategoryDTO;
import com.master.stock.dto.CategoryRegisterDTO;
import com.master.stock.model.Category;
import com.master.stock.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<CategoryDTO> listCategory() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .toList();
    }
}

//return games.stream().map(game -> {
//List<ConquestWithoutIdDTO> conquestDTOs = game.getConquests().stream()
//        .map(conquest -> new ConquestWithoutIdDTO(conquest.getName(), conquest.getDescription()))
//        .collect(Collectors.toList());
//
//            return new GameDTO(game.getTitle(), game.getGender(), game.getPlatform(), game.getClassification(), conquestDTOs);
//        }).collect(Collectors.toList());

