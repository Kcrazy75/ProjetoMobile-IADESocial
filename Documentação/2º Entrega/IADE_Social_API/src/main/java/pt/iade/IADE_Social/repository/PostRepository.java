package pt.iade.IADE_Social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.iade.IADE_Social.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    // CRUD methods are inherited from JpaRepository 
}
