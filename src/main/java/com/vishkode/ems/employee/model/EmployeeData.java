package com.vishkode.ems.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeData {

    private Long id;
    @NonNull
    private String firstName;
    private String middleName;
    @NonNull
    private String lastName;
    @NonNull
    private String emailId;
    @NonNull
    private String phoneNumber;

    public EmployeeData(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.middleName = employee.getMiddleName();
        this.lastName = employee.getLastName();
        this.emailId = employee.getEmailId();
        this.phoneNumber = employee.getPhoneNumber();
    }
}
