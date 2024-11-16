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
@Table(name = "product_view")
public class ProductView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_view_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_risk")
    private Risk risk;

    @ManyToOne
    @JoinColumn(name = "id_type_insured")
    private TypeInsured typeInsured;

    public ProductView() {
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

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public TypeInsured getTypeInsured() {
        return typeInsured;
    }

    public void setTypeInsured(TypeInsured typeInsured) {
        this.typeInsured = typeInsured;
    }

    @Override
    public String toString() {
        return "ProductView{" +
                "product=" + product +
                ", risk=" + risk +
                ", typeInsured=" + typeInsured +
                '}';
    }
}
