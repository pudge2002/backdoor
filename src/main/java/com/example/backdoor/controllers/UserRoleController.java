package com.example.backdoor.controllers;

import com.example.backdoor.model.UserRole;
import com.example.backdoor.repos.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @PutMapping("/{id}")
    public UserRole updateUserRole(@PathVariable Long id, @RequestBody UserRole userRoleDetails) {
        UserRole userRole = userRoleRepository.findById(id).orElse(null);
        if (userRole != null) {
            userRole.setUser(userRoleDetails.getUser());
            userRole.setRole(userRoleDetails.getRole());
            return userRoleRepository.save(userRole);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRoleRepository.deleteById(id);
    }
}

