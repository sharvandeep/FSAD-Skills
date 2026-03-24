package com.example.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProductRepository repo) {
        return args -> {

            repo.save(new Product("Laptop", "Electronics", 65000));
            repo.save(new Product("Mouse", "Electronics", 800));
            repo.save(new Product("Chair", "Furniture", 3000));
            repo.save(new Product("Table", "Furniture", 7000));
            repo.save(new Product("Notebook", "Stationery", 120));

        };
    }
}