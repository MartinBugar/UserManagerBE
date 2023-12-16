package com.martyx.employeemanager.service;

import com.martyx.employeemanager.model.Employee;

import java.util.List;


public interface EmployeeService {

    /**
     * Store the employee to DB.
     *
     * @param employee .
     * @return instance of saved employee.
     */
    Employee addEmployee(Employee employee);

    /**
     * Find the employee by id.
     *
     * @param id .
     * @return instance of saved employee.
     */
    Employee findEmployeeById(Integer id);

    /**
     * Find all employees.
     *
     * @return all employees from DB.
     */
    List<Employee> findAllEmployees();

    /**
     * Update employee by its id.
     *
     * @param employee .
     * @return instance of updated employee.
     */
    Employee updateEmployee(Employee employee);

    /**
     * Delete employee by its id.
     *
     * @param id .
     */
    void deleteEmployee(Integer id);
}
