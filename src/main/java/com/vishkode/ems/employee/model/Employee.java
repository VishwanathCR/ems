package com.vishkode.ems.employee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private String phoneNumber;

    public Employee(EmployeeData employeeData) {
        this.id = employeeData.getId();
        this.firstName = employeeData.getFirstName();
        this.middleName = employeeData.getMiddleName();
        this.lastName = employeeData.getLastName();
        this.emailId = employeeData.getEmailId();
        this.phoneNumber = employeeData.getPhoneNumber();
    }
}
