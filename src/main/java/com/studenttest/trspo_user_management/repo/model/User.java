package com.studenttest.trspo_user_management.repo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.studenttest.trspo_user_management.repo.model.enums.UserType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
public final class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String email;
    private String firstName;
    private String lastName;
    private UserType userType;

    public User(String email, String firstName, String lastName, UserType userType) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }
}