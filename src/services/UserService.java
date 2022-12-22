package services;

import data.model.User;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterResponse;

public interface UserService{
    RegisterResponse createUser(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);
    User find(String email);

    void delete(String email);
}
