package com.example.backdoor.controllers;

import com.example.backdoor.model.ProductView;
import com.example.backdoor.repos.ProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-views")
public class ProductViewController {

    @Autowired
    private ProductViewRepository productViewRepository;

    @GetMapping
    public List<ProductView> getAllProductViews() {
        return productViewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductView getProductViewById(@PathVariable Long id) {
        return productViewRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ProductView createProductView(@RequestBody ProductView productView) {
        return productViewRepository.save(productView);
    }

    @PutMapping("/{id}")
    public ProductView updateProductView(@PathVariable Long id, @RequestBody ProductView productViewDetails) {
        ProductView productView = productViewRepository.findById(id).orElse(null);
        if (productView != null) {
            productView.setProduct(productViewDetails.getProduct());
            productView.setRisk(productViewDetails.getRisk());
            productView.setTypeInsured(productViewDetails.getTypeInsured());
            return productViewRepository.save(productView);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProductView(@PathVariable Long id) {
        productViewRepository.deleteById(id);
    }
}

