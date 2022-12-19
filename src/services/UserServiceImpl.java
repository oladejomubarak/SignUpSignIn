package services;

import data.model.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryInterface;

public class UserServiceImpl implements UserService, UserRepositoryInterface {

    private final UserRepository userRepository = new UserRepository();

    @Override
    public User createUser(String firstName, String lastName, String email, String password, String phoneNumber) {
    User user = new User(firstName, lastName,email, password, phoneNumber);
        return userRepository.save(user);
    }
}
