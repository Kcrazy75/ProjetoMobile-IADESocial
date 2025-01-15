package pt.iade.IADESocial.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "profiles")
public class Profiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProfileID")
    private int id;

    @NotNull(message = "User ID cannot be null")
    @Column(name = "UserID", nullable = false)
    private int userId;

    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Column(name = "Name")
    private String name;

    @Size(max = 65535, message = "Bio cannot exceed 65535 characters")
    @Column(name = "Bio", columnDefinition = "TEXT")
    private String bio;

    @Size(max = 255, message = "Profile picture path cannot exceed 255 characters")
    @Column(name = "ProfilePicture")
    private String profilePicture;

    // Default constructor
    public Profiles() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}

