package com.example.BE_LinkKien.Service;


import com.example.BE_LinkKien.Models.Brand;
import com.example.BE_LinkKien.Models.ImageProduct;
import com.example.BE_LinkKien.Models.Product;
import com.example.BE_LinkKien.Models.Specification;
import com.example.BE_LinkKien.Repository.BrandRepository;
import com.example.BE_LinkKien.Repository.ImagePeoductRepository;
import com.example.BE_LinkKien.Repository.ProductRepository;
import com.example.BE_LinkKien.Repository.SpecificationRepository;
import com.example.BE_LinkKien.exception.CustomException;
import com.example.BE_LinkKien.payload.resquest.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SpecificationRepository specificationRepository;
    @Autowired
    private ImagePeoductRepository imagePeoductRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Product createProduct(ProductRequest product)
    {
        Product _product = new Product();

        List<Specification> specificationList = new ArrayList<>();
        List<ImageProduct> imageProductList = new ArrayList<>();

        _product.setId(product.getId());
        _product.setName(product.getName());
        _product.setDescription(_product.getDescription());
        _product.setPrice(product.getPrice());
        _product.setStatus(true);
        _product.setIdBrand(product.getIdBrand());
        _product.setIdCategory(product.getIdCategory());
        _product.setIdEvent(null);

        Product product1 = productRepository.save(_product);

        product.getSpecification().forEach((e)->{
            Specification specification = new Specification();
            specification.setSpecification(e);
            specification.setIdProduct(product.getId());
//            specification.setProduct(_product);
            specificationList.add(specification);
        });
        specificationRepository.saveAll(specificationList);

        product.getImageProducts().forEach((e)->{
            ImageProduct imageProduct = new ImageProduct();
            imageProduct.setName(e.getName());
            imageProduct.setImage(e.getImage());
            imageProduct.setIdProduct(product.getId());
//            imageProduct.setProduct(_product);
            imageProductList.add(imageProduct);
        });
        imagePeoductRepository.saveAll(imageProductList);


        return product1;
    }

}
