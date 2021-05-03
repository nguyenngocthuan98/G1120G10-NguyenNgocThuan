package com.exam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "loai_san_pham")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_sp")
    private Integer typeProductId;

    @Column(name = "ten_loai_sp", columnDefinition = "VARCHAR(100) NOT NULL")
    private String typeProductName;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    private Set<Product> productSet;
}
