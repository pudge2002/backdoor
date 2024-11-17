package com.example.backdoor.controllersAPI;

import com.example.backdoor.model.TypeInsured;
import com.example.backdoor.repos.TypeInsuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-insured")
public class TypeInsuredController {

    @Autowired
    private TypeInsuredRepository typeInsuredRepository;

    @GetMapping
    public List<TypeInsured> getAllTypeInsured() {
        return typeInsuredRepository.findAll();
    }

    @GetMapping("/{id}")
    public TypeInsured getTypeInsuredById(@PathVariable Long id) {
        return typeInsuredRepository.findById(id).orElse(null);
    }

    @PostMapping
    public TypeInsured createTypeInsured(@RequestBody TypeInsured typeInsured) {
        return typeInsuredRepository.save(typeInsured);
    }

    @PutMapping("/{id}")
    public TypeInsured updateTypeInsured(@PathVariable Long id, @RequestBody TypeInsured typeInsuredDetails) {
        TypeInsured typeInsured = typeInsuredRepository.findById(id).orElse(null);
        if (typeInsured != null) {
            typeInsured.setType(typeInsuredDetails.getType());
            typeInsured.setProduct(typeInsuredDetails.getProduct());
            return typeInsuredRepository.save(typeInsured);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTypeInsured(@PathVariable Long id) {
        typeInsuredRepository.deleteById(id);
    }
}
