package com.master.stock.controller;

import com.master.stock.dto.CategoryRegisterDTO;
import com.master.stock.model.Category;
import com.master.stock.repository.CategoryRepository;
import com.master.stock.repository.ProductRepository;
import com.master.stock.repository.SupplierRepository;
import com.master.stock.service.CategoryService;
import com.master.stock.service.ProductService;
import com.master.stock.service.SupplierService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final CategoryService categoryService;

    private final ProductService productService;

    private final SupplierService supplierService;

    public MainController(CategoryService categoryService, ProductService productService, SupplierService supplierService, CategoryRepository categoryRepository, ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @PostMapping("category")
    @Transactional
    public ResponseEntity registerCategory(@RequestBody @Valid CategoryRegisterDTO dto) {
        Category category = categoryService.registerCategory(dto);
        return ResponseEntity.ok(category);
    }

}
