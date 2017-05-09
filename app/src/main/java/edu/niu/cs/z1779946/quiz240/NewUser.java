package edu.niu.cs.z1779946.quizapp;

/**
 * Created by DARSHAN on 4/23/2017.
 */

public class NewUser {
    int id;
    String fullName, email, userName, password;

    public NewUser(int id, String fullName, String email, String userName, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public NewUser(String fullName, String email, String userName, String password) {
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
