package com.martyx.employeemanager.controller;

import com.martyx.employeemanager.model.User;
import com.martyx.employeemanager.service.UserService;
import com.martyx.employeemanager.service.UserServiceBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceBean employeeService) {
        this.userService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllEmployees() {
        List<User> users = userService.findAllEmployees();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable("id") Integer id) {
        User userById = userService.findEmployeeById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addEmployee(@RequestBody User user) {
        User newUser = userService.addEmployee(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateEmployee(@RequestBody User user) {
        User updateUser = userService.updateEmployee(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        userService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
