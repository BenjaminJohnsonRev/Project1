package org.example.entity;

public class Employee {

    private String username;
    private String password;
    private int userId;

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(String username, String password, int accountId) {
        this.username = username;
        this.password = password;
        this.userId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
