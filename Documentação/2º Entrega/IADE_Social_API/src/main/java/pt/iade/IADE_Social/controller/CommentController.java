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

import pt.iade.IADE_Social.model.Comment;
import pt.iade.IADE_Social.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired 
    private CommentService commentService; 
    
    @GetMapping public List<Comment> getAllComments() { return commentService.getAllComments(); }

    @GetMapping("{id}") 
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) { 
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK); 
    } 
    
    @PostMapping 
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) { 
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED); 
    }

    @PutMapping("{id}") 
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Integer id) { 
        Comment updatedComment = commentService.updateComment(comment, id); 
        if (updatedComment != null) { return new ResponseEntity<>(updatedComment, HttpStatus.OK); } 
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } 
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Void> deleteCommentById(@PathVariable("id") Integer id) { 
        commentService.deleteCommentById(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
