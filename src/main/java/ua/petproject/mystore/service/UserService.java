package ua.petproject.mystore.service;

import ua.petproject.mystore.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
