package com.case_study.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @Column(name = "customer_id", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^KH-[\\d]{4}$", message = "CustomerID must be in format KH-xxxx(x is a number)")
    private String customerId;

    @Column(name = "customer_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String customerBirthday;

    @Column(name = "customer_gender")
    private boolean customerGender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45) NOT NULL UNIQUE")
    @Pattern(regexp = "^[\\d]{9}|[\\d]{12}$", message = "Id card must be 9 or 12 digits")
    private String customerIdCard;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^09[0|1][\\d]{7}|\\(84\\)\\+9[0|1][\\d]{7}$",
            message = "Phone number format: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx, x is a number")
    private String customerPhone;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^([\\w]+-?\\.?)+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email invalid")
    private String customerEmail;

    @Column(name = "customer_address", columnDefinition = "VARCHAR(45)")
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;


    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;

        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(customer.getCustomerBirthday());
            Date currentDate = new Date();

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -18);
            Date back18Years = calendar.getTime();

            if (birthday.after(back18Years)) {
                errors.rejectValue("customerBirthday", "date.birthday.lessThan18");
            }
            if (birthday.after(currentDate)) {
                errors.rejectValue("customerBirthday", "date.birthday.future");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
