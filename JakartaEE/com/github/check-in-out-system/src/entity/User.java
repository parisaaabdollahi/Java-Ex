package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String family;
    private String employeeCode;
    private String password;

    public User() {

    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    private String role;

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

    public String getEmployeeCode() {
        return employeeCode;
    }

    public User setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User(String name, String family,String role, String employeeCode, String password) {
        this.name = name;
        this.family = family;
        this.employeeCode = employeeCode;
        this.password = password;
    }

    public User(String name, String family , String role) {
        this.name = name;
        this.family = family;
    }
}
