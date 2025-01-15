package pt.iade.IADESocial.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iade.IADESocial.models.Users;


import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    // Buscar uma pessoa pelo e-mail
    Optional<Users> findByEmail(String email);

    // Verificar se um e-mail já está cadastrado
    boolean existsByEmail(String email);
}

