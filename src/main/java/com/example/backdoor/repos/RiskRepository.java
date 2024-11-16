package com.example.backdoor.repos;

import com.example.backdoor.model.Risk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRepository extends JpaRepository<Risk, Long> {
}