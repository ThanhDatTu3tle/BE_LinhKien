package com.example.BE_LinkKien.Repository;

import com.example.BE_LinkKien.Models.ImageProduct;
import com.example.BE_LinkKien.Models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagePeoductRepository extends JpaRepository<ImageProduct, Integer> {
    boolean existsByName(String name);


}
