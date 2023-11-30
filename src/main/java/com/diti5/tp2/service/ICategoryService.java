package com.diti5.tp2.service;
import com.diti5.tp2.entities.Category;

import java.util.List;

public interface ICategoryService {

    Category create (Category category);

    List<Category> category();
    Category update(Integer id, Category category);

    String delete(Integer id);
}
