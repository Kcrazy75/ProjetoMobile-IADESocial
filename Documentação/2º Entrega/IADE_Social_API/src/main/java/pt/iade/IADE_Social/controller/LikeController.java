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

import pt.iade.IADE_Social.model.Like;
import pt.iade.IADE_Social.service.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired 
    private LikeService likeService; 
    
    @GetMapping 
    public List<Like> getAllLikes() { return likeService.getAllLikes(); } 
    
    @GetMapping("{id}") 
    public ResponseEntity<Like> getLikeById(@PathVariable Integer id) { 
        return new ResponseEntity<>(likeService.getLikeById(id), HttpStatus.OK); 
    }

    @PostMapping 
    public ResponseEntity<Like> createLike(@RequestBody Like like) { 
        return new ResponseEntity<>(likeService.createLike(like), HttpStatus.CREATED); 
    }

    @PutMapping("{id}") 
    public ResponseEntity<Like> updateLike(@RequestBody Like like, @PathVariable Integer id) { 
        Like updatedLike = likeService.updateLike(like, id); 
        if (updatedLike != null) { return new ResponseEntity<>(updatedLike, HttpStatus.OK); } 
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } 
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Void> deleteLikeById(@PathVariable("id") Integer id) { 
        likeService.deleteLikeById(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
