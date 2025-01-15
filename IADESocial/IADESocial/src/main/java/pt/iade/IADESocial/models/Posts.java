package pt.iade.IADESocial.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private int id;

    @NotNull(message = "Profile ID cannot be null")
    @Column(name = "ProfileID", nullable = false)
    private int profileId;

    @NotBlank(message = "Content cannot be empty")
    @Column(name = "Content", columnDefinition = "TEXT", nullable = false)
    private String content;

    // Default constructor
    public Posts() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

