package com.case_study.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username", columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(50) NOT NULL")
    private String password;

    @Column(name = "enabled", length = 1, columnDefinition = "BIT DEFAULT 1")
    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User() {
    }

    public User(Integer userId, String username, String password, boolean enabled, Employee employee) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
