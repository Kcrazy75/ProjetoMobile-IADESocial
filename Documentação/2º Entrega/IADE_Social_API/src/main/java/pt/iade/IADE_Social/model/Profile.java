package pt.iade.IADE_Social.model; 

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data; 

@Entity
@Data 
@Table(name = "Profiles") 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "profileID")
public class Profile { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "ProfileID") 
    private Integer profileID; 
    
    @Column(name = "Name") 
    private String name; 
    
    @Column(name = "Bio") 
    private String bio; 
    
    @Column(name = "ProfilePicture") 
    private String profilePicture; 
    
    @OneToOne
    @JoinColumn(name = "UserID", nullable = false) 
    private User user; 
    
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Post> posts;
    
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Comment> comments; 
    
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Follower> followers; 
    
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Follower> following;
    
    // Getters and setters 
    public Integer getProfileID() { return profileID; } 
    public void setProfileID(Integer profileID) { this.profileID = profileID; } 
    
    public User getUser() { return user; } 
    public void setUser(User user) { this.user = user; } 
    
    public String getName() { return name; } 
    public void setName(String name) { this.name = name; } 
    
    public String getBio() { return bio; } 
    public void setBio(String bio) { this.bio = bio; } 
    
    public String getProfilePicture() { return profilePicture; } 
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; } 
    
    public List<Post> getPosts() { return posts; } 
    public void setPosts(List<Post> posts) { this.posts = posts; }
    
    public List<Comment> getComments() { return comments; } 
    public void setComments(List<Comment> comments) { this.comments = comments; } 
    
    public List<Follower> getFollowers() { return followers; } 
    public void setFollowers(List<Follower> followers) { this.followers = followers; } 
    
    public List<Follower> getFollowing() { return following; } 
    public void setFollowing(List<Follower> following) { this.following = following; }
}
