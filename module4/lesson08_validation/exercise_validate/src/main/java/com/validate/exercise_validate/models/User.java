package com.validate.exercise_validate.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Not empty")
    @Size(min = 5, max = 45, message = "First name must be > 5 and < 45 characters ")
    private String firstName;

    @NotBlank(message = "Not empty")
    @Size(min = 5, max = 45, message = "Last name must be > 5 and < 45 characters ")
    private String lastName;

    private String phoneNumbers;

    @NotNull(message = "Not empty")
    @Range(min = 18, message = "Age must be over 18")
    @Pattern(regexp = "^\\d$", message = "Age must be a number")
    private String age;

    private String email;

    public User() {
    }

    public User(Integer id,
                @NotBlank @Size(min = 5, max = 45, message = "First name must be > 5 and < 45 characters ") String firstName,
                @NotBlank @Size(min = 5, max = 45, message = "Last name must be > 5 and < 45 characters ") String lastName,
                String phoneNumbers,
                @NotBlank @Min(value = 18, message = "Age must be over 18") String age,
                String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        String phoneNumber = user.getPhoneNumbers();
        String emailCheck = user.getEmail();

        ValidationUtils.rejectIfEmpty(errors, "phoneNumbers", "phoneNumber.empty");
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumbers", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumbers", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumbers", "phoneNumber.matches");
        }
        if (!emailCheck.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$")) {
            errors.rejectValue("email", "emailCheck.matches");
        }
    }
}
