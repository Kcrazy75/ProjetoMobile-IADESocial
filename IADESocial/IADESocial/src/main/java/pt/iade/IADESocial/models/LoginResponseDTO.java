package pt.iade.IADESocial.models;

public class LoginResponseDTO {
    private int userId;
    private String token;

    public LoginResponseDTO(int userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    // Getters e Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
