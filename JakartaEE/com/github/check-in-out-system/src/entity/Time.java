package entity;

import java.io.Serializable;

public class Time implements Serializable {
    private Long id;
    private String username;
    private long login;
    private long logout;

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public Time setId(Long id) {
        this.id = id;
        return this;
    }

    public Time setUsername(String username) {
        this.username = username;
        return this;
    }

    public long getLogin() {
        return login;
    }

    public Time setLogin(long login) {
        this.login = login;
        return this;
    }

    public long getLogout() {
        return logout;
    }

    public Time setLogout(long logout) {
        this.logout = logout;
        return this;
    }
}
