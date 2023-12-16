package com.martyx.employeemanager.service;

import com.martyx.employeemanager.exception.EmployeeNotFoundException;
import com.martyx.employeemanager.model.Employee;
import com.martyx.employeemanager.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service bean for Employee entity.
 */
@Service
public class EmployeeServiceBean implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceBean(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee was not found"));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        if (id == null) {
            throw new EmployeeNotFoundException("Employee with id not exist");
        } else {
            employeeRepository.deleteById(id);
        }
    }
}
