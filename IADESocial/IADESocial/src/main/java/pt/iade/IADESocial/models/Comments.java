package pt.iade.IADESocial.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID")
    private int id;

    @NotNull(message = "Post ID cannot be null")
    @Column(name = "PostID", nullable = false)
    private int postId;

    @NotNull(message = "Profile ID cannot be null")
    @Column(name = "ProfileID", nullable = false)
    private int profileId;

    @NotBlank(message = "Content cannot be empty")
    @Column(name = "Content", columnDefinition = "TEXT", nullable = false)
    private String content;

    // Default constructor
    public Comments() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

