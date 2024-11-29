package pt.iade.IADE_Social.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.iade.IADE_Social.model.Post;
import pt.iade.IADE_Social.repository.PostRepository;
import pt.iade.IADE_Social.service.PostService;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository pstRep;

    //get all posts
    @Override
    public List<Post> getAllPosts(){ return pstRep.findAll(); }

    //Get Post By ID
    @Override
    public Post getPostByID(Integer id) { 
        Optional<Post> post =  pstRep.findById(id);
        
        if(post.isPresent()){ return post.get(); }    //post.get()
        else { throw new RuntimeException("Post not found with id " + id); }
    }

    //Create Post
    @Override
    public Post createPost(Post post) { return pstRep.save(post); }

    //Update Post
    @Override
    public Post updatePost(Post post, Integer id) { 
        Optional<Post> existingPost = pstRep.findById(id); 

        if(existingPost.isPresent()){
            Post updatedPost = existingPost.get();
            updatedPost.setContent(post.getContent());
            updatedPost.setPicture(post.getPicture());

            return pstRep.save(updatedPost);
        } else{ return null; } 
    }

    //Delete Post
    @Override
    public void deletePostById(Integer id) { 
        //check
        pstRep.findById(id).orElseThrow( () -> new RuntimeException("Post not found with id " + id) );
        //delete
        pstRep.deleteById(id);    
    }
}
