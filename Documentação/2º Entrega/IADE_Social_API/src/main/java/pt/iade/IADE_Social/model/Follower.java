package pt.iade.IADE_Social.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "followers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "followerID")
public class Follower {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "FollowerID") 
    private Integer followerID; 
    
    @ManyToOne 
    @JoinColumn(name = "ProfileID", nullable = false)
    private Profile profile; 
    
    @ManyToOne
    @JoinColumn(name = "FollowerProfileID", nullable = false)
    private Profile followerProfile; 
    
    // Getters and Setters 
    public Integer getFollowerID() { return followerID; } 
    public void setFollowerID(Integer followerID) { this.followerID = followerID; } 
    
    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
    
    public Profile getFollowerProfile() { return followerProfile; }
    public void setFollowerProfile(Profile followerProfile) { this.followerProfile = followerProfile; }
}
