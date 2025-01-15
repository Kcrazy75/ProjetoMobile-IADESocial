package pt.iade.IADESocial.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iade.IADESocial.models.Comments;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findByPostId(int postId);  // Método para buscar comentários pelo PostID
}
