package com.example.backdoor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "slices")
public class Slice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slice_id")
    private Long id;

    @Column(name = "slice_name", nullable = false)
    private String name;

    public Slice() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Slice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
