package pt.iade.IADE_Social.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.iade.IADE_Social.model.Comment;
import pt.iade.IADE_Social.repository.CommentRepository;
import pt.iade.IADE_Social.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired 
    private CommentRepository cmtRep; 
    
    @Override 
    public List<Comment> getAllComments() { return cmtRep.findAll(); } 
    
     @Override
    public Comment getCommentById(Integer id) { 
        Optional<Comment> comment = cmtRep.findById(id); 
        
        if (comment.isPresent()) { return comment.get(); } 
        else { throw new RuntimeException("Comment not found with id " + id); } 
    } 
    
    @Override 
    public Comment createComment(Comment comment) { return cmtRep.save(comment); } 
    
    @Override 
    public Comment updateComment(Comment comment, Integer id) { 
        Optional<Comment> existingComment = cmtRep.findById(id); 
        
        if (existingComment.isPresent()) { 
            Comment updatedComment = existingComment.get(); 
            updatedComment.setContent(comment.getContent()); 
            
            return cmtRep.save(updatedComment); 
        } else { return null; } 
    } 
        
    @Override 
    public void deleteCommentById(Integer id) { 
        // check 
        cmtRep.findById(id).orElseThrow(() -> new RuntimeException("Comment not found with id " + id)); 
        // delete 
        cmtRep.deleteById(id); 
    }
}
