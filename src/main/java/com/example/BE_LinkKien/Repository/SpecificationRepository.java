package com.example.BE_LinkKien.Repository;

import com.example.BE_LinkKien.Models.Product;
import com.example.BE_LinkKien.Models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, Integer> {



}
