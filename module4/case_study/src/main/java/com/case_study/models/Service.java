package com.case_study.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45)")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceName;

    @Column(name = "service_area", nullable = false)
    private int serviceArea;

    @Column(name = "service_cost", nullable = false)
    private double serviceCost;

    @Column(name = "service_max_people", nullable = false)
    private int serviceMaxPeople;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    private String standardRoom;

    @Column(name = "description", columnDefinition = "VARCHAR(45)")
    private String description;

    @Column(name = "pool_area")
    private double poolArea;

    @Column(name = "number_of_floors")
    private int NumberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

}
