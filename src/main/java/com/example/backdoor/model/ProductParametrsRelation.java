package com.example.backdoor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "product_parameters_relations")
public class ProductParametrsRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parameters_slice_relations_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parameters_id", nullable = false)
    private Parametrs parametrs;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @Column(name = "name", nullable = false)
    private String name;
    public ProductParametrsRelation() {
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

    public Parametrs getParametrs() {
        return parametrs;
    }

    public void setParametrs(Parametrs parametrs) {
        this.parametrs = parametrs;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return name;
    }
}
