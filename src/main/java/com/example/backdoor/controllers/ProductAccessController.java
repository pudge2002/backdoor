package com.example.backdoor.controllers;

import com.example.backdoor.model.ProductAccess;
import com.example.backdoor.repos.ProductAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-access")
public class ProductAccessController {

    @Autowired
    private ProductAccessRepository productAccessRepository;

    @GetMapping
    public List<ProductAccess> getAllProductAccess() {
        return productAccessRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductAccess getProductAccessById(@PathVariable Long id) {
        return productAccessRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ProductAccess createProductAccess(@RequestBody ProductAccess productAccess) {
        return productAccessRepository.save(productAccess);
    }

    @PutMapping("/{id}")
    public ProductAccess updateProductAccess(@PathVariable Long id, @RequestBody ProductAccess productAccessDetails) {
        ProductAccess productAccess = productAccessRepository.findById(id).orElse(null);
        if (productAccess != null) {
            productAccess.setUserRole(productAccessDetails.getUserRole());
            productAccess.setProduct(productAccessDetails.getProduct());
            return productAccessRepository.save(productAccess);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProductAccess(@PathVariable Long id) {
        productAccessRepository.deleteById(id);
    }
}
