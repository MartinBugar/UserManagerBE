package com.martyx.employeemanager.service;

import com.martyx.employeemanager.model.User;

import java.util.List;


public interface UserService {

    /**
     * Store the user to DB.
     *
     * @param user .
     * @return instance of saved user.
     */
    User addEmployee(User user);

    /**
     * Find the employee by id.
     *
     * @param id .
     * @return instance of saved employee.
     */
    User findEmployeeById(Integer id);

    /**
     * Find all employees.
     *
     * @return all employees from DB.
     */
    List<User> findAllEmployees();

    /**
     * Update user by its id.
     *
     * @param user .
     * @return instance of updated user.
     */
    User updateEmployee(User user);

    /**
     * Delete employee by its id.
     *
     * @param id .
     */
    void deleteEmployee(Integer id);
}
