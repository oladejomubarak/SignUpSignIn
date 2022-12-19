package services;

import data.model.User;

public interface UserService{
    User createUser(String firstName, String lastName, String email,String password, String phoneNumber );
}
