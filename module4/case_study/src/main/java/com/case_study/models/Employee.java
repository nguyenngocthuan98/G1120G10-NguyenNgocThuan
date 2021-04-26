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
@Table(name = "employee")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    private String employeeBirthday;

    @Column(name = "employee_id_card", columnDefinition = "VARCHAR(45) NOT NULL UNIQUE")
    @Pattern(regexp = "^[\\d]{9}|[\\d]{12}$", message = "Id card must be 9 or 12 digits")
    private String employeeIdCard;

    @Column(name = "employee_salary", columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+(.[\\d]+)?$", message = "Not a number.")
    private String employeeSalary;

    @Column(name = "employee_phone", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^09[0|1][\\d]{7}|\\(84\\)\\+9[0|1][\\d]{7}$",
            message = "Phone number format: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx, x is a number")
    private String employeePhone;

    @Column(name = "employee_email", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^([\\w]+-?\\.?)+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email invalid")
    private String employeeEmail;

    @Column(name = "employee_address", columnDefinition = "VARCHAR(45)")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Employee employee = (Employee) object;
        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(employee.getEmployeeBirthday());
            Date currentDate = new Date();

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -18);
            Date back18Years = calendar.getTime();

            if (birthday.after(back18Years)) {
                errors.rejectValue("employeeBirthday", "date.birthday.lessThan18");
            }
            if (birthday.after(currentDate)) {
                errors.rejectValue("employeeBirthday", "date.birthday.future");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
