package pt.iade.IADE_Social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.iade.IADE_Social.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    // CRUD methods are inherited from JpaRepository 
}
