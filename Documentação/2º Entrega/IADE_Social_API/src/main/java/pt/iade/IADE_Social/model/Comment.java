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
@Table(name = "Comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "commentID")
public class Comment { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID") 
    private Integer commentID;
    
    @Column(name = "Content", nullable = false)
    private String content;
    
    @ManyToOne 
    @JoinColumn(name = "PostID", nullable = false)
    private Post post; 
    
    @ManyToOne 
    @JoinColumn(name = "ProfileID", nullable = false) 
    private Profile profile;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Like> likes;
    
    // Getters and setters
    public Integer getCommentID() { return commentID; } 
    public void setCommentID(Integer commentID) { this.commentID = commentID; }

    public Integer getPostID() { return post.getPostID(); } 
    public void setPostID(Integer postID) { this.post.setPostID(postID); }

    public Post getPost() { return post; } 
    public void setPost(Post post) { this.post = post; }

    public Profile getProfile() { return profile; } 
    public void setProfile(Profile profile) { this.profile = profile; }

    public String getContent() { return content; } 
    public void setContent(String content) { this.content = content; }

    public List<Like> getLikes() { return likes; } 
    public void setLikes(List<Like> likes) { this.likes = likes; }
}
