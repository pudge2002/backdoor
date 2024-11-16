package com.example.backdoor.repos;

import com.example.backdoor.model.ProductAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAccessRepository extends JpaRepository<ProductAccess, Long> {
}
