package org.example.dao;

import org.example.domain.User;

import java.util.List;

public interface UserDAO {
    int insertUser(User user);
    User queryUser(String userName);
}
