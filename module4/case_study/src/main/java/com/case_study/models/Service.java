package com.case_study.models;

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
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^DV-[\\d]{4}$", message = "ServiceID must be in format DV-xxxx(x is a number)")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceName;

    @Column(name = "service_area", nullable = false, columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+(.[\\d]+)?$", message = "Not a number.")
    private String serviceArea;

    @Column(name = "service_cost", nullable = false, columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+(.[\\d]+)?$", message = "Not a number.")
    private String serviceCost;

    @Column(name = "service_max_people", nullable = false, columnDefinition = "INT")
    @Pattern(regexp = "^[\\d]+$", message = "Wrong number!")
    private String serviceMaxPeople;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^VIP|Normal|Business|$", message = "Must be VIP, Normal, Business or empty")
    private String standardRoom;

    @Column(name = "description", columnDefinition = "VARCHAR(45)")
    private String description;

    @Column(name = "pool_area", columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+(.[\\d]+)?$", message = "Not a number.")
    private String poolArea;

    @Column(name = "number_of_floors", columnDefinition = "INT")
    @Pattern(regexp = "^[\\d]+$", message = "Wrong number!")
    private String NumberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

}
