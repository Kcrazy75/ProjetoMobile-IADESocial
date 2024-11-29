package pt.iade.IADE_Social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.IADE_Social.model.Follower;
import pt.iade.IADE_Social.service.FollowerService;

@RestController
@RequestMapping("/api/Followers")
public class FollowerController {
    @Autowired 
    private FollowerService followerService; 
    
    @GetMapping 
    public List<Follower> getAllFollowers() { return followerService.getAllFollowers(); } 
    
    @GetMapping("{id}") 
    public ResponseEntity<Follower> getFollowerById(@PathVariable Integer id) { 
        return new ResponseEntity<>(followerService.getFollowerById(id), HttpStatus.OK); 
    }

    @PostMapping 
    public ResponseEntity<Follower> createFollower(@RequestBody Follower follower) { 
        return new ResponseEntity<>(followerService.createFollower(follower), HttpStatus.CREATED); 
    } 
    
    @PutMapping("{id}") 
    public ResponseEntity<Follower> updateFollower(@RequestBody Follower follower, @PathVariable Integer id) { 
        Follower updatedFollower = followerService.updateFollower(follower, id); 
        if (updatedFollower != null) { return new ResponseEntity<>(updatedFollower, HttpStatus.OK); } 
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } 
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Void> deleteFollowerById(@PathVariable Integer id) { 
        followerService.deleteFollowerById(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
