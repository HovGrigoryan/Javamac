package blog.model;

import java.util.Objects;

public class User {
    private String name;
    private String surnaname;
    private String email;
    private String password;
    private UserType userType;

    public User(String name, String surnaname, String email, String password, UserType userType) {
        this.name = name;
        this.surnaname = surnaname;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnaname() {
        return surnaname;
    }

    public void setSurnaname(String surnaname) {
        this.surnaname = surnaname;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surnaname, user.surnaname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surnaname, email, password, userType);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surnaname='" + surnaname + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}

