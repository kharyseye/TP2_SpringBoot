package com.diti5.tp2.service;

import com.diti5.tp2.entities.Product;
import com.diti5.tp2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> products() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Integer id, Product product) {
        return productRepository.findById(id)
                .map(p ->{
                    p.setDesignation(product.getDesignation());
                    p.setPrice(product.getPrice());
                    p.setQuantity(product.getQuantity());

                    return productRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Product not found!"))
                ;
    }


    @Override
    public String delete(Integer id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }
}
