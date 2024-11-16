package com.example.backdoor.repos;

import com.example.backdoor.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductViewRepository extends JpaRepository<ProductView, Long> {
}

