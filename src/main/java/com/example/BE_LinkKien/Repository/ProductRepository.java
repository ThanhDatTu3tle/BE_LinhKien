package com.example.BE_LinkKien.Repository;

import com.example.BE_LinkKien.Models.Brand;
import com.example.BE_LinkKien.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    boolean existsByName(String name);


}
