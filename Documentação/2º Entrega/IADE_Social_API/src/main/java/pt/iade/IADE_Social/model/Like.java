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
@Table(name = "likes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "likeID")
public class Like {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "LikeID") 
    private Integer likeID; 
    
    @ManyToOne 
    @JoinColumn(name = "PostID") 
    private Post post;

    @ManyToOne 
    @JoinColumn(name = "ProfileID", nullable = true) 
    private Profile profile;

    @ManyToOne 
    @JoinColumn(name = "CommentID") 
    private Comment comment;
    
    // Getters and Setters 
    public Integer getLikeID() { return likeID; } 
    public void setLikeID(Integer likeID) { this.likeID = likeID; }

    public Profile getProfile() { return profile; } 
    public void setProfile(Profile profile) { this.profile = profile; }
    
    public Post getPost() { return post; } 
    public void setPost(Post post) { this.post = post; }

    public Comment getComment() { return comment; } 
    public void setComment(Comment comment) { this.comment = comment; }
}
