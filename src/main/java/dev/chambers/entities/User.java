package dev.chambers.entities;

import java.util.Arrays;

public abstract class User {

    //artifact of when employees and finance managers were separate artifacts
    int user_id;
    String email;
    String pass;
    String name;

    public User(){}

    public User(int user_id, String email, String pass, String name) {
        this.user_id=user_id;
        this.email = email;
        this.pass = pass;
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public int getId() {
        return user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' + '}';
    }
}
