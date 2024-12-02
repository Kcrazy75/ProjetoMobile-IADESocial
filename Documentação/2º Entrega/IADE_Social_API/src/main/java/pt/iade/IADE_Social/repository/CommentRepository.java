package pt.iade.IADE_Social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.iade.IADE_Social.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    // CRUD methods are inherited from JpaRepository 
}
