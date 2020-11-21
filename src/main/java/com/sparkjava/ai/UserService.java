package com.sparkjava.ai;

import org.omg.CORBA.UserException;

import java.util.Collection;

public interface UserService {
    public void addUser(User user);

    public Collection<User> getUsers();

    public User getUser(String id);

    public User editUser(User user) throws UserException, com.sparkjava.ai.UserException;

    public void deleteUser(String id);

    public boolean userExist(String id);
}
