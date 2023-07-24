package com.example.BE_LinkKien.Controller;

import com.example.BE_LinkKien.Models.Brand;
import com.example.BE_LinkKien.Models.Category;
import com.example.BE_LinkKien.Service.BrandService;
import com.example.BE_LinkKien.Service.CategoryService;
import com.example.BE_LinkKien.payload.response.ResponseObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createBrand(@RequestParam String name, @RequestParam String image) {
        return ResponseEntity.ok().body(new ResponseObject("success",200, "Create brand successfully",brandService.createBrand(name,image)));
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAllBrand() {
        return ResponseEntity.ok().body(new ResponseObject("success",200, "Get all brand successfully",brandService.getAllBrand()));
    }
    @PostMapping("/getCategory")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getBrand(@RequestParam Integer id) {
        return ResponseEntity.ok().body(new ResponseObject("success",200, "Get brand successfully",brandService.getById(id)));
    }
    @PutMapping("/edit")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editBrand(@RequestBody Brand category1) {
        return ResponseEntity.ok().body(new ResponseObject("success",200, "Edit brand successfully",brandService.editBrand(category1)));
    }


    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteCategory(@RequestParam Integer id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok().body(new ResponseObject("success",200, "Delete brand successfully",null));
    }
}
