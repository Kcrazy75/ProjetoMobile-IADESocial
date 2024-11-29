package pt.iade.IADE_Social.service;

import java.util.List;
import java.util.Optional;

import pt.iade.IADE_Social.model.User;

public interface UserService {
    List<User> getAllUsers(); 
    User getUserById(Integer id);
    User updateUser(User user, Integer id);
    User createUser(User user); 
    void deleteUserById(Integer id);

    public void updatePasswords();
    Optional<User> authenticateUser(String username, String password);
}