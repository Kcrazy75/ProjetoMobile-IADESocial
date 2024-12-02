package pt.iade.IADE_Social.service;

import java.util.List;

import pt.iade.IADE_Social.model.Follower;

public interface FollowerService {
    List<Follower> getAllFollowers(); 
    Follower getFollowerById(Integer id); 
    Follower createFollower(Follower follower); 
    Follower updateFollower(Follower follower, Integer id); 
    void deleteFollowerById(Integer id);
}
