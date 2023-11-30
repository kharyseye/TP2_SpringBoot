package com.diti5.tp2.controller;

import com.diti5.tp2.entities.Product;
import com.diti5.tp2.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductRestController {

    private IProductService iproductService;

    @GetMapping("/list")
    public List<Product> read(){

        return iproductService.products();
    }

    @PostMapping("/create")
    public Product create (@RequestBody Product product){
        return iproductService.create(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product product){
        return iproductService.update(id, product);
    }
    @DeleteMapping("/delete")
    public String delete(@PathVariable Integer id){
        return iproductService.delete(id);
    }

}
