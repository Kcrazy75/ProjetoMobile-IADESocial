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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Posts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "postID")
public class Post { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID") 
    private Integer postID;
    
    @Column(name = "Picture")
    private String picture;

    @Column(name = "Content")
    private String content;

    @ManyToOne 
    @JoinColumn(name = "ProfileID", nullable = false)
    private Profile profile;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Comment> comments; 

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Like> likes;
    
    // Getters and setters
    public Integer getPostID() { return postID; } 
    public void setPostID(Integer postID) { this.postID = postID; }

    public Profile getProfile() { return profile; } 
    public void setProfile(Profile profile) { this.profile = profile; }

    public String getContent() { return content; } 
    public void setContent(String content) { this.content = content; }

    public String getPicture(){ return picture; }
    public void setPicture(String picture){ this.picture = picture; }

    public List<Comment> getComments() { return comments; } 
    public void setComments(List<Comment> comments) { this.comments = comments; }

    public List<Like> getLikes() { return likes; } 
    public void setLikes(List<Like> likes) { this.likes = likes; }
}
