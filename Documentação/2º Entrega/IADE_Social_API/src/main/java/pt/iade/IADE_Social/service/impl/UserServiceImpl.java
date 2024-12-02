package pt.iade.IADE_Social.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pt.iade.IADE_Social.model.User;
import pt.iade.IADE_Social.repository.UserRepository;
import pt.iade.IADE_Social.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRep;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    //get all users from database
    @Override
    public List<User> getAllUsers(){ return userRep.findAll(); }

    //get User by ID
    @Override
    public User getUserById(Integer id) {
        Optional<User> user =  userRep.findById(id);
        
        if(user.isPresent()){ return user.get(); }    //user.get();
        else { throw new RuntimeException("User not found with id " + id); }
    }

    //create User
    @Override
    public User createUser(User user) { 
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getProfile().setUser(user);        //Ensures Profiles are assigned to users on creation, so no null pointer exceptions get thrown
        return userRep.save(user); 
    }    

    //update user
    @Override
    public User updateUser(User user, Integer id){
        Optional<User> existingUser = userRep.findById(id);

        if(existingUser.isPresent()){
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername()); 
            updatedUser.setEmail(user.getEmail()); 
            updatedUser.setPassword(user.getPassword()); 
            updatedUser.setStudentID(user.getStudentID());

            return userRep.save(updatedUser);
        } else { return null; }
    }

    //delete user by id
    @Override
    public void deleteUserById(Integer id){
        //check
        userRep.findById(id).orElseThrow( () -> new RuntimeException("User not found with id " + id) );
        //delete
        userRep.deleteById(id);
    }

    @Override 
    public Optional<User> authenticateUser(String username, String password) { 
        Optional<User> user = userRep.findByUsername(username); 
        if ((user.isPresent() && passwordEncoder.matches(password, user.get().getPassword()))) { return user; } 
        //if (user.isPresent() && password.equals(user.get().getPassword())) { return user; }
        else { return Optional.empty(); } 
    }

    // Method to update passwords for all users 
    @Override
    public void updatePasswords() { 
        List<User> users = userRep.findAll(); 
        for (User user : users) { 
            // Check if the password is already encoded 
            if (!isEncoded(user.getPassword())) { 
                // Encode the password and update the user 
                user.setPassword(passwordEncoder.encode(user.getPassword())); 
                userRep.save(user); 
            } 
        } 
    } 
    
    private boolean isEncoded(String password) { 
        // Simple check to determine if the password is encoded 
        // BCrypt encoded passwords typically start with "$2a$" 
        return password.startsWith("$2a$10$"); 
    }
}
