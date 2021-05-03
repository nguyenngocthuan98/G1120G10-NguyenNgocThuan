package com.exam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "san_pham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sp")
    private Integer productId;

    @Column(name = "ten_sp", columnDefinition = "VARCHAR(100) NOT NULL")
    private String productName;

    @Column(name = "gia_sp", columnDefinition = "DOUBLE NOT NULL")
    @Pattern(regexp = "^[\\d](.[\\d])?$", message = "Phai la so va khong de trong!")
    private String productPrice;

    @Column(name = "tinh_trang_sp", columnDefinition = "VARCHAR(45) NOT NULL")
    private String productState;

    @ManyToOne
    @JoinColumn(name = "ma_loai_sp", nullable = false)
    private TypeProduct typeProduct;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Orders> ordersSet;
}
