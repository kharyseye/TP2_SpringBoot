package com.diti5.tp2.service;

import com.diti5.tp2.entities.Product;

import java.util.List;

public interface IProductService {

    Product create (Product product);

    List<Product> products();
    Product update(Integer id, Product product);

    String delete(Integer id);
}
