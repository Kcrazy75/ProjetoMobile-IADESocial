package pt.iade.IADESocial.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.IADESocial.models.Profiles;

import java.util.Optional;

public interface ProfilesRepository extends CrudRepository<Profiles, Integer> {
    Optional<Profiles> findByUserId(int userId); // Método para buscar perfil pelo userId
}

