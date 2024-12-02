package pt.iade.IADE_Social.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import pt.iade.IADE_Social.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> { 
    // CRUD methods are inherited from JpaRepository 
}