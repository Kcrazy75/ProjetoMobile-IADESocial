package pt.iade.IADESocial.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LikeID")
    private int id;

    @NotNull(message = "Post ID cannot be null")
    @Column(name = "PostID", nullable = false)
    private int postId;

    @NotNull(message = "Profile ID cannot be null")
    @Column(name = "ProfileID", nullable = false)
    private int profileId;

    // Default constructor
    public Likes() {}

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
}
