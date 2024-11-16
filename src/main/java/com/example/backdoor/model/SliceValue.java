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
@Table(name = "slice_values")
public class SliceValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slice_value_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "slice_id", nullable = false)
    private Slice slice;

    @Column(name = "value", nullable = false)
    private String value;

    public SliceValue() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Slice getSlice() {
        return slice;
    }

    public void setSlice(Slice slice) {
        this.slice = slice;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SliceValue{" +
                "id=" + id +
                ", slice=" + slice +
                ", value='" + value + '\'' +
                '}';
    }
}
