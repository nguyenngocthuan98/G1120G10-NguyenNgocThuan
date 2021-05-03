package com.exam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "don_hang")
public class Orders implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private Integer orderId;

    @Column(name = "ngay_mua", columnDefinition = "DATE")
    private String orderDate;

    @Column(name = "so_luong", columnDefinition = "INT NOT NULL")
    @Pattern(regexp = "^[\\d]$", message = "Quantity must be positive numbers!")
    private String orderQuantity;

    @ManyToOne
    @JoinColumn(name = "ma_sp", nullable = false)
    private Product product;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
