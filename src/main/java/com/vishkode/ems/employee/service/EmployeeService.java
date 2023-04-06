package com.vishkode.ems.employee.service;

import com.vishkode.ems.employee.model.EmployeeData;

import java.util.List;

public interface EmployeeService {
    List<EmployeeData> getAllEmployees();

    EmployeeData getEmployeeById(Long employeeId);

    Long createEmployee(EmployeeData employeeData);

    Long updateEmployee(Long employeeId, EmployeeData employeeData);
}
