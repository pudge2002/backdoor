package com.example.backdoor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "slices")
public class Slice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slice_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parameters_id", nullable = false)
    private Parametrs parametrs;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private String value;

    public Slice() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parametrs getParametrs() {
        return parametrs;
    }

    public void setParametrs(Parametrs parametrs) {
        this.parametrs = parametrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Slice{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", parametrs=" + parametrs +
                '}';
    }
}
