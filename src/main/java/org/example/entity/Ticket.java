package org.example.entity;

import java.sql.Timestamp;

public class Ticket implements Comparable<Ticket>{
    private int ticketid;
    private int userid;
    private String status;
    private String name;
    private double reimbursement;
    private String description;
    private Timestamp ticketTime;

    public Ticket(){

    }


    public Ticket(int ticketid, int userid, String status, String name, double reimbursement, String description, Timestamp ticketTime) {

        this.ticketid = ticketid;
        this.userid = userid;
        this.status = status;
        this.name = name;
        this.reimbursement = reimbursement;
        this.description = description;
        this.ticketTime = ticketTime;
    }

    public Ticket(int userid, String status, String name, double reimbursement, String description) {

        this.userid = userid;
        this.status = status;
        this.name = name;
        this.reimbursement = reimbursement;
        this.description = description;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public String getAccepted() {
        return status;
    }

    public void setAccepted(String status) {
        this.status = status;
    }

    public double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(double reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Timestamp ticketTime) {
        this.ticketTime = ticketTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketid=" + ticketid +
                ", userid=" + userid +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", reimbursement=" + reimbursement +
                ", description='" + description + '\'' +
                ", ticketTime=" + ticketTime +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {return this.ticketTime.compareTo(o.ticketTime);
    }
}
