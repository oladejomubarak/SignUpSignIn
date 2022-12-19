package controller;

import data.model.User;
import data.repository.UserRepositoryInterface;
import services.UserService;
import services.UserServiceImpl;

public class UserController {
    private final UserService userService = new UserServiceImpl();

    public User register(String firstName, String lastName, String email, String password, String phoneNumber){
        return userService.createUser(firstName, lastName, email, password, phoneNumber);
    }
}
