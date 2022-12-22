package services;

import data.model.User;
import data.repository.UserRepository;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterResponse;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new UserRepository();

    @Override
    public RegisterResponse createUser(RegisterRequest registerRequest) {
        if(userRepository.findUserByKey(registerRequest.getEmail()) != null)
            throw new RuntimeException("Email already exits, choose another email");
        User user = new User(registerRequest.getFirstName(), registerRequest.getLastName(),
            registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getPhoneNumber());
        User savedUser = userRepository.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setMessage("successful");
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();
        User foundUser = userRepository.findUserByKey(loginRequest.getEmail());
        if(foundUser == null) throw new RuntimeException("Email does not exits, please register");
        foundUser.setEmail(loginRequest.getEmail());
        User setPassword = foundUser.setPassword(loginRequest.getPassword());
        User confirmPassword = foundUser.setPassword(loginRequest.getPassword());
        if (setPassword.equals(confirmPassword)) response.setMessage("You are successfully logged in");
        return response;
    }

    @Override
    public User find(String email) {
        return userRepository.findUserByKey(email);
    }

    @Override
    public void delete(String email) {
        userRepository.delete(email);
    }
}
