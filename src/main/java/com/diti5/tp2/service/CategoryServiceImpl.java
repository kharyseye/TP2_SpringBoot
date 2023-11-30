package com.diti5.tp2.service;

import com.diti5.tp2.entities.Category;
import com.diti5.tp2.repository.CategoryRepository;
import com.diti5.tp2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> category() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Integer id, Category category) {
        return categoryRepository.findById(id)
                .map(c ->{
                    c.setName(category.getName());
                    return categoryRepository.save(c);
                }).orElseThrow(() -> new RuntimeException("category not found!"))
                ;
    }

    @Override
    public String delete(Integer id) {
        categoryRepository.deleteById(id);
        return "category deleted";
    }
}
