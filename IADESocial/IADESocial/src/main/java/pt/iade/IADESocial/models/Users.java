package pt.iade.IADESocial.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int id;


    @Column(name = "Username", unique = true, nullable = false)
    private String username;


    @Email(message = "Email should be valid")

    @Column(name = "Email", unique = true, nullable = false)
    private String email;


    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "StudentID", nullable = true)
    private int studentId;

    // Default constructor
    public Users() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
