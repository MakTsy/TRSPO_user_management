package com.studenttest.trspo_user_management.service;

import java.util.List;

import com.studenttest.trspo_user_management.repo.model.User;
import com.studenttest.trspo_user_management.repo.model.enums.UserType;

public interface UserManagementService {
    List<User> fetchAllStudents();
    User fetchUserById(long id) throws IllegalArgumentException;
    long createUser(String email, String firstName, String lastName, UserType userType);
    void updateUser(long id, String email, String firstName, String lastName, UserType userType) throws IllegalArgumentException;
    void deleteUser(long id);
}
