package com.example.backdoor.controllers;

import com.example.backdoor.model.Parametrs;
import com.example.backdoor.repos.ParametrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parametrs")
public class ParametrsController {

    @Autowired
    private ParametrsRepository parametrsRepository;

    @GetMapping
    public List<Parametrs> getAllParametrs() {
        return parametrsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Parametrs getParametrsById(@PathVariable Long id) {
        return parametrsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Parametrs createParametrs(@RequestBody Parametrs parametrs) {
        return parametrsRepository.save(parametrs);
    }

    @PutMapping("/{id}")
    public Parametrs updateParametrs(@PathVariable Long id, @RequestBody Parametrs parametrsDetails) {
        Parametrs parametrs = parametrsRepository.findById(id).orElse(null);
        if (parametrs != null) {
            parametrs.setName(parametrsDetails.getName());
            parametrs.setType(parametrsDetails.getType());
            parametrs.setValue(parametrsDetails.getValue());
            parametrs.setSliceCount(parametrsDetails.getSliceCount());
            return parametrsRepository.save(parametrs);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteParametrs(@PathVariable Long id) {
        parametrsRepository.deleteById(id);
    }
}

