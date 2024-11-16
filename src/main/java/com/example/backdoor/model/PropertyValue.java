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
@Table(name = "property_values")
public class PropertyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_value_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "object_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "property_slice_id", nullable = false)
    private PropertySliceRelation propertySliceRelation;

    @ManyToOne
    @JoinColumn(name = "slice_value_id")
    private SliceValue sliceValue;

    @Column(name = "value")
    private String value;

    public PropertyValue() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PropertySliceRelation getPropertySliceRelation() {
        return propertySliceRelation;
    }

    public void setPropertySliceRelation(PropertySliceRelation propertySliceRelation) {
        this.propertySliceRelation = propertySliceRelation;
    }

    public SliceValue getSliceValue() {
        return sliceValue;
    }

    public void setSliceValue(SliceValue sliceValue) {
        this.sliceValue = sliceValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "id=" + id +
                ", product=" + product +
                ", propertySliceRelation=" + propertySliceRelation +
                ", sliceValue=" + sliceValue +
                ", value='" + value + '\'' +
                '}';
    }
}