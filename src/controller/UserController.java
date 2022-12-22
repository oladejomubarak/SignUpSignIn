package controller;

import data.model.User;
import dtos.requests.RegisterRequest;
import dtos.responses.RegisterResponse;
import services.UserService;
import services.UserServiceImpl;

public class UserController {
    private final UserService userService = new UserServiceImpl();

    public RegisterResponse registerUser(RegisterRequest registerRequest){
        return userService.createUser(registerRequest);
    }
    public User findUser(String email){
        return userService.find(email);
    }
    public void deleteUser(String email){
        userService.delete(email);
    }
}
