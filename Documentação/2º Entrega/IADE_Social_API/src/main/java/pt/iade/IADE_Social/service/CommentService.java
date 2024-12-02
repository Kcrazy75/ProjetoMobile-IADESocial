package pt.iade.IADE_Social.service;

import java.util.List;

import pt.iade.IADE_Social.model.Comment;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Integer id);
    Comment createComment(Comment comment);
    Comment updateComment(Comment comment, Integer id);
    void deleteCommentById(Integer id);
}
