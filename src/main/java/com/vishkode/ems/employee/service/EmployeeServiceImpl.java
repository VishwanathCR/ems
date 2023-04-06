package com.vishkode.ems.employee.service;

import com.vishkode.ems.employee.model.Employee;
import com.vishkode.ems.employee.model.EmployeeData;
import com.vishkode.ems.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeData> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeData::new)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeData getEmployeeById(Long employeeId) {
        return Optional.ofNullable(employeeRepository.findById(employeeId)).get()
                .map(EmployeeData::new)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found - " + employeeId));
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found - " + employeeId));
    }

    @Override
    public Long createEmployee(EmployeeData employeeData) {
        Employee employee = Optional.ofNullable(employeeData)
                .map(Employee::new)
//                .orElseThrow(() -> new BadRequestException("Invalid request"));
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request"));
        employee = employeeRepository.save(employee);
        return employee.getId();
    }

    @Override
    public Long updateEmployee(Long employeeId, EmployeeData employeeData) {
        Employee employee = Optional.ofNullable(this.employeeRepository.findById(employeeId)).get()
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found - " + employeeData.getId()));
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found - " + employeeId));
        this.employeeRepository.save(employee);
        return employee.getId();
    }
}
