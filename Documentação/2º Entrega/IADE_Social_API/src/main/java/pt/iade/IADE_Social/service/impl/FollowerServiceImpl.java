package pt.iade.IADE_Social.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.iade.IADE_Social.model.Follower; 
import pt.iade.IADE_Social.repository.FollowerRepository;
import pt.iade.IADE_Social.service.FollowerService;

@Service
public class FollowerServiceImpl implements FollowerService{
    @Autowired 
    private FollowerRepository followerRepository;

    @Override 
    public List<Follower> getAllFollowers() { return followerRepository.findAll(); } 
    
    @Override 
    public Follower getFollowerById(Integer id) { 
        Optional<Follower> follower = followerRepository.findById(id); 
        
        if (follower.isPresent()) { return follower.get(); } 
        else { throw new RuntimeException("Follower not found with id " + id); } 
    }

    @Override 
    public Follower createFollower(Follower follower) { return followerRepository.save(follower); } 
    
    @Override 
    public Follower updateFollower(Follower follower, Integer id) { 
        Optional<Follower> existingFollower = followerRepository.findById(id); 
        
        if (existingFollower.isPresent()) { 
            Follower updatedFollower = existingFollower.get(); 
            updatedFollower.setProfile(follower.getProfile()); 
            updatedFollower.setFollowerProfile(follower.getFollowerProfile()); 
            
            return followerRepository.save(updatedFollower); 
        } else { return null; } 
    }

    @Override 
    public void deleteFollowerById(Integer id) { 
        // check 
        followerRepository.findById(id).orElseThrow(() -> new RuntimeException("Follower not found with id " + id)); 
        // delete 
        followerRepository.deleteById(id); 
    }
}
