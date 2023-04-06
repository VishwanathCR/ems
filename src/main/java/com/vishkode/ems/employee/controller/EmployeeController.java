package com.vishkode.ems.employee.controller;

import com.vishkode.ems.employee.model.EmployeeData;
import com.vishkode.ems.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeData>> getAllEmployees() {
        List<EmployeeData> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeData> getEmployeeById(@PathVariable final Long employeeId) {
        EmployeeData employeeData = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok().body(employeeData);
    }

    @PostMapping
    public ResponseEntity<Long> createEmployee(@RequestBody final EmployeeData employeeData) {
        Long employeeId = employeeService.createEmployee(employeeData);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<Long> updateEmployee(@PathVariable final Long employeeId, @RequestBody final EmployeeData employeeData) {
        employeeService.updateEmployee(employeeId, employeeData);
        return ResponseEntity.status(HttpStatus.OK).body(employeeId);
    }
}
