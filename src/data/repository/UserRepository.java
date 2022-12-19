package data.repository;

import data.model.User;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, User> userDB = new HashMap<>();

    public User save(User user){

        userDB.put(user.getEmail(), user);

        return user;
    }

    public User findByKey(String email){
        return userDB.get(email);
    }

    public User delete(String email){
        return userDB.remove(email);
    }
}
