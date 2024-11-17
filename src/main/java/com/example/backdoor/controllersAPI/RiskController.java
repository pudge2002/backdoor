package com.example.backdoor.controllersAPI;

import com.example.backdoor.model.Risk;
import com.example.backdoor.repos.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risks")
public class RiskController {

    @Autowired
    private RiskRepository riskRepository;

    @GetMapping
    public List<Risk> getAllRisks() {
        return riskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Risk getRiskById(@PathVariable Long id) {
        return riskRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Risk createRisk(@RequestBody Risk risk) {
        return riskRepository.save(risk);
    }

    @PutMapping("/{id}")
    public Risk updateRisk(@PathVariable Long id, @RequestBody Risk riskDetails) {
        Risk risk = riskRepository.findById(id).orElse(null);
        if (risk != null) {
            risk.setName(riskDetails.getName());
            risk.setLevel(riskDetails.getLevel());
            risk.setProduct(riskDetails.getProduct());
            return riskRepository.save(risk);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRisk(@PathVariable Long id) {
        riskRepository.deleteById(id);
    }
}

