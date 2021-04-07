package com.validate.practice_validate_form_input.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5, max = 20, message = "Input wrong, must be 5-20 characters")
    private String name;

    @NotBlank
    @Size(min = 18, message = "Too young, must over 18")
    private int age;

    public Input() {
    }

    public Input(Integer id,
                 @NotBlank @Size(min = 5, max = 20, message = "Input wrong, must be 5-20 characters")
                         String name, @NotBlank @Size(min = 18, message = "Too young, must over 18") int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
