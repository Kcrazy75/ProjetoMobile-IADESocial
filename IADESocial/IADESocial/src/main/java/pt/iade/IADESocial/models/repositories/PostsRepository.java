package pt.iade.IADESocial.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.IADESocial.models.Posts;

import java.util.List;

public interface PostsRepository extends CrudRepository<Posts, Integer> {
    // Método para buscar posts por profileId
    List<Posts> findByProfileId(int profileId);
}

