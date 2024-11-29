package pt.iade.IADE_Social.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.IADE_Social.model.User;
import pt.iade.IADE_Social.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Get All Users REST API
    @GetMapping
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    //Get User By ID REST API
    @GetMapping("{id}") 
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        System.out.println("\ngetting user with ID: "+id+"\n"); 
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK); 
    }

    //Create user REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("\nCreating user with username: "+user.getUsername()+"\n");
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    
    //Update User by ID REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id){
        User updatedUser = userService.updateUser(user, id); 
        if (updatedUser != null) { return new ResponseEntity<>(updatedUser, HttpStatus.OK); } 
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    //Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
        //delete User from DataBase
        System.out.println("\nDeleting user with ID: "+id+"\n");
        userService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted Successfully.", HttpStatus.OK);
    }

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
        public ResponseEntity<User> signup(@RequestBody User user) { 
        user.getProfile().setUser(user);
        User newUser = userService.createUser(user); 
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login") 
    public ResponseEntity<User> authenticateUser(@RequestParam String username, @RequestParam String password) { 
        System.out.println("\n Authenticating: "+username+" With Password: "+password+"\n");
        Optional<User> user = userService.authenticateUser(username, password); 
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

    @PostMapping("/update-passwords") 
    public ResponseEntity<?> updatePasswords() { 
        userService.updatePasswords(); 
        return ResponseEntity.ok("Passwords updated successfully");
    }
}
