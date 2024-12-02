package pt.iade.IADE_Social.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Data
@Table(name = "Users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userID")
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID") 
    private Integer userID; 
    
    @Column(name = "Username",nullable = false)
    private String username;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "Password",nullable = false)
    private String password;

    @Column(name = "StudentID",nullable = false)
    private Integer studentID;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) 
    private Profile profile; 
    
    // Getters and setters 
    public Integer getUserID() { return userID; } 
    public void setUserID(Integer userID) { this.userID = userID; } 
    
    public String getUsername() { return username; } 
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; } 
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; } 
    public void setPassword(String password) { this.password = password; }

    public Integer getStudentID() { return studentID; } 
    public void setStudentID(Integer studentID) { this.studentID = studentID; }

    public Profile getProfile() { return profile; } 
    public void setProfile(Profile profile) { this.profile = profile; }
}
