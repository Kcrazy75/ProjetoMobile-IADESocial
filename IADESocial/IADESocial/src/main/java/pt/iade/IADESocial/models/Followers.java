package pt.iade.IADESocial.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "followers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ProfileID", "FollowerProfileID"})
})
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FollowerID")
    private int id;

    @NotNull(message = "Profile ID cannot be null")
    @Column(name = "ProfileID", nullable = false)
    private int profileId;

    @NotNull(message = "Follower Profile ID cannot be null")
    @Column(name = "FollowerProfileID", nullable = false)
    private int followerProfileId;

    // Default constructor
    public Followers() {}

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

    public int getFollowerProfileId() {
        return followerProfileId;
    }

    public void setFollowerProfileId(int followerProfileId) {
        this.followerProfileId = followerProfileId;
    }
}

