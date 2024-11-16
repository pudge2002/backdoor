package com.example.backdoor.repos;

import com.example.backdoor.model.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyValueRepository extends JpaRepository<PropertyValue, Long> {
}

