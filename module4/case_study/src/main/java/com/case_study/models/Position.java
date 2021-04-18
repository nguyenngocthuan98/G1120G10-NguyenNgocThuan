package com.case_study.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employeeSet;

    public Position() {
    }

    public Position(Integer positionId, String positionName, Set<Employee> employeeSet) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employeeSet = employeeSet;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
