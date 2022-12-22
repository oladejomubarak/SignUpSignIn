package data.repository;

import data.model.User;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, User> userDB = new HashMap<>();

    public User save(User user){
        userDB.put(user.getEmail(), user);
        return user;
    }

    public User findUserByKey(String email){
        for (String userEmail : userDB.keySet()) if (userEmail.equals(email)) return userDB.get(email);
        return null;
    }

    public User delete(String email){
        return userDB.remove(email);
    }
}
