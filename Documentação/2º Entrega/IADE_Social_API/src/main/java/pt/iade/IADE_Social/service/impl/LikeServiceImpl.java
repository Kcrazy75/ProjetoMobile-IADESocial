package pt.iade.IADE_Social.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.iade.IADE_Social.model.Like;
import pt.iade.IADE_Social.repository.LikeRepository;
import pt.iade.IADE_Social.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService { 
    @Autowired 
    private LikeRepository likeRep;

    @Override 
    public List<Like> getAllLikes() { return likeRep.findAll(); }

    @Override 
    public Like getLikeById(Integer id) { 
        Optional<Like> like = likeRep.findById(id); 
        
        if (like.isPresent()) { return like.get(); } 
        else { throw new RuntimeException("Like not found with id " + id); } 
    }

    @Override 
    public Like createLike(Like like) { return likeRep.save(like); }

    @Override 
    public Like updateLike(Like like, Integer id) { 
        Optional<Like> existingLike = likeRep.findById(id); 
        
        if (existingLike.isPresent()) { 
            Like updatedLike = existingLike.get(); 
            updatedLike.setProfile(like.getProfile()); 
            updatedLike.setPost(like.getPost()); 
            updatedLike.setComment(like.getComment()); 
            
            return likeRep.save(updatedLike); 
        } else { return null; } 
    }

    @Override 
    public void deleteLikeById(Integer id) { 
        // check 
        likeRep.findById(id).orElseThrow(() -> new RuntimeException("Like not found with id " + id)); 
        // delete 
        likeRep.deleteById(id); 
    }
}
