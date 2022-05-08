package org.example.entity;

public class Employee {

    private String username;
    private String password;
    private int userid;

    public Employee(){

    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(int userid, String username, String password) {

        this.username = username;
        this.password = password;
        this.userid = userid;
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

    public int getUserid() {
        return userid;
    }

//    public void setUserid(int userid) {
//        this.userid = userid;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userid=" + userid +
                '}';
    }
}
