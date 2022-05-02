package org.example.entity;

public class Manager {

    private String username;
    private String password;

    boolean managerStatus = true;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
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

    public boolean isManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(boolean managerStatus) {
        this.managerStatus = managerStatus;
    }



    @Override
    public void login(String username, String password) {
    }

}
