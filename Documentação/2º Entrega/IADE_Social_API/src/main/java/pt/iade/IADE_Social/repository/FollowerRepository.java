package pt.iade.IADE_Social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.iade.IADE_Social.model.Follower; 

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Integer> {
        // CRUD methods are inherited from JpaRepository 
}
