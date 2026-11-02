package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

     void createUser(User user);

     User getUser(Long id);

     List<User> getAllUsers();

     void updateUser(User user);

     void deleteUser(Long id);
}
