
package com.example.product;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo){
        this.repo = repo;
    }
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return repo.save(product);
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return repo.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min,@RequestParam double max){
        return repo.findByPriceBetween(min,max);
    }

    @GetMapping("/sorted")
    public List<Product> sorted(){
        return repo.findAllSortedByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price){
        return repo.findExpensiveProducts(price);
    }
}
