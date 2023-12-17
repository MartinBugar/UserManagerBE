package com.martyx.employeemanager.service;

import com.martyx.employeemanager.exception.UserNotFoundException;
import com.martyx.employeemanager.model.User;
import com.martyx.employeemanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service bean for User entity.
 */
@Service
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceBean(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addEmployee(User user) {
        user.setEmployeeCode(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User findEmployeeById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User was not found"));
    }

    @Override
    public List<User> findAllEmployees() {
        return userRepository.findAll();
    }

    @Override
    public User updateEmployee(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteEmployee(Integer id) {
        if (id == null) {
            throw new UserNotFoundException("User with id not exist");
        } else {
            userRepository.deleteById(id);
        }
    }
}
