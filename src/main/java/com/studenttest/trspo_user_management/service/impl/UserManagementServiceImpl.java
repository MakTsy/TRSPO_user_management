package com.studenttest.trspo_user_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studenttest.trspo_user_management.repo.UserRepo;
import com.studenttest.trspo_user_management.repo.model.User;
import com.studenttest.trspo_user_management.repo.model.enums.UserType;
import com.studenttest.trspo_user_management.service.UserManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public final class UserManagementServiceImpl implements UserManagementService {

    private final UserRepo userRepo;

    public List<User> fetchAllStudents() {
        return userRepo.findAllByUserType(UserType.STUDENT);
    }

    public User fetchUserById(long id) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepo.findById(id);

        if(maybeUser.isPresent())
            return maybeUser.get();
        else
            throw new IllegalArgumentException("Invalid user ID");
    }

    public long createUser(String email, String firstName, String lastName, UserType userType) {
        final User user = new User(email, firstName, lastName, userType);
        final User savedUser = userRepo.save(user);

        return savedUser.getId();
    }

    public void updateUser(long id, String email, String firstName, String lastName, UserType userType) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepo.findById(id);

        if(maybeUser.isEmpty())
            throw new IllegalArgumentException("Invalid user ID");

        final User user = maybeUser.get();
        if (email != null && !email.isBlank()) user.setEmail(email);
        if (firstName != null && !firstName.isBlank()) user.setFirstName(firstName);
        if (lastName != null && !lastName.isBlank()) user.setLastName(lastName);
        if (userType != null) user.setUserType(userType);
        userRepo.save(user);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}
