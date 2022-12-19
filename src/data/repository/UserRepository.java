package data.repository;

import data.model.User;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, User> userDB = new HashMap<>();

    public User save(User user){
        if (!userDB.containsKey(user.getEmail())) userDB.put(user.getEmail(), user);
        else throw new RuntimeException("Email already exists, choose another email");
        return user;
    }

    public User findByKey(String email){
        return userDB.get(email);
    }

    public User delete(String email){
        return userDB.remove(email);
    }
}
