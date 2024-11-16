package com.example.backdoor.controllers;

import com.example.backdoor.model.ProductParametrsRelation;
import com.example.backdoor.repos.ProductParametrsRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-parametrs-relations")
public class ProductParametrsRelationController {

    @Autowired
    private ProductParametrsRelationRepository productParametrsRelationRepository;

    @GetMapping
    public List<ProductParametrsRelation> getAllProductParametrsRelations() {
        return productParametrsRelationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductParametrsRelation getProductParametrsRelationById(@PathVariable Long id) {
        return productParametrsRelationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ProductParametrsRelation createProductParametrsRelation(@RequestBody ProductParametrsRelation productParametrsRelation) {
        return productParametrsRelationRepository.save(productParametrsRelation);
    }

    @PutMapping("/{id}")
    public ProductParametrsRelation updateProductParametrsRelation(@PathVariable Long id, @RequestBody ProductParametrsRelation productParametrsRelationDetails) {
        ProductParametrsRelation productParametrsRelation = productParametrsRelationRepository.findById(id).orElse(null);
        if (productParametrsRelation != null) {
            productParametrsRelation.setParametrs(productParametrsRelationDetails.getParametrs());
            productParametrsRelation.setProduct(productParametrsRelationDetails.getProduct());
            return productParametrsRelationRepository.save(productParametrsRelation);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProductParametrsRelation(@PathVariable Long id) {
        productParametrsRelationRepository.deleteById(id);
    }
}
