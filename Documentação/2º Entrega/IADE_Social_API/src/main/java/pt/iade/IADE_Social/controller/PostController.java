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

import pt.iade.IADE_Social.model.Post;
import pt.iade.IADE_Social.service.PostService;
//import pt.iade.IADE_Social.service.UserService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    //Get All Posts REST API
    @GetMapping
    public List<Post> getAllPosts() { return postService.getAllPosts(); }

    //Get Post By ID REST API
    @GetMapping("{id}") 
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) { 
        return new ResponseEntity<>(postService.getPostByID(id), HttpStatus.OK); 
    }

    //Create Post REST API
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    //Update Post by ID REST API
    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Integer id){
        Post updatedPost = postService.updatePost(post, id); 
        if (updatedPost != null) { return new ResponseEntity<>(updatedPost, HttpStatus.OK); } 
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    //Delete Post REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Integer id){
        //delete User from DataBase
        postService.deletePostById(id);
        return new ResponseEntity<>("Post Deleted Successfully.", HttpStatus.OK);
    }
}
