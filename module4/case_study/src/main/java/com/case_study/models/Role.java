package com.case_study.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(name = "ROLE_UK", columnNames = "role_name")})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", nullable = false, columnDefinition = "VARCHAR(45) NOT NULL UNIQUE")
    private String roleName;

}
