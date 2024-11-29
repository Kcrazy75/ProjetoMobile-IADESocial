package pt.iade.IADE_Social.service;

import java.util.List;

import pt.iade.IADE_Social.model.Like; 

public interface LikeService { 
    List<Like> getAllLikes(); 
    Like getLikeById(Integer id); 
    Like createLike(Like like); 
    Like updateLike(Like like, Integer id); 
    void deleteLikeById(Integer id); 
}