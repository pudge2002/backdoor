package com.example.backdoor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "parameters")
public class Parametrs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parameters_id")
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "type", nullable = false)
    private String type;


    @Column(name = "value")
    private String value;


    @Column(name = "number_of_slices")
    private Integer sliceCount;

    public Parametrs() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSliceCount() {
        return sliceCount;
    }

    public void setSliceCount(Integer sliceCount) {
        this.sliceCount = sliceCount;
    }

    @Override
    public String toString() {
        return "Parametrs{" +
                "sliceCount=" + sliceCount +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

