package com.studenttest.trspo_user_management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studenttest.trspo_user_management.repo.model.User;
import com.studenttest.trspo_user_management.repo.model.enums.UserType;

public interface UserRepo  extends JpaRepository<User, Long> {
    @Query
    List<User> findAllByUserType(UserType userType);
}
