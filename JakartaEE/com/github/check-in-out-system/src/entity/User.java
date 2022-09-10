package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String family;
    private String username;
    private String password;
    private String role;
    public User() {

    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public User setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User(String name, String family,String role, String username, String password) {
        this.name = name;
        this.family = family;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public User(String name, String family , String role) {
        this.name = name;
        this.family = family;
        this.role=role;
    }
}
