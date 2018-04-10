package hwr.sem4.csa.util;

import javax.persistence.*;


@Entity
@Table(name = "Users") //Reason for error = unknown
public class User {
@Id
private String username;

private String userPassword;

private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
