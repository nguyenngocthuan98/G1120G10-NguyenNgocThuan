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
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contract")
public class Contract implements Validator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATETIME")
    private String contractStartDate;

    @Column(name = "contract_end_date", columnDefinition = "DATETIME")
    private String contractEndDate;

    @Column(name = "contract_deposit", columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+(.[\\d]+)?$", message = "Not a number.")
    private String contractDeposit;

    @Column(name = "contract_total_money")
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetailSet;

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Contract contract = (Contract) object;
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractStartDate());
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractEndDate());
            Date currentDate = new Date();

            if (startDate.after(endDate)) {
                errors.rejectValue("contractStartDate", "contract.time_start.afterEnd");
            }
            if (endDate.before(startDate)) {
                errors.rejectValue("contractEndDate", "contract.time_end.beforeStart");
            }
            if (endDate.before(currentDate)){
                errors.rejectValue("contractEndDate", "contract.time_end.beforeCurrent");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
