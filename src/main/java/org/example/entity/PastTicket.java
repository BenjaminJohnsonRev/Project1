package org.example.entity;

import java.sql.Timestamp;


public class PastTicket {

    private int ticketid;
    private int userid;
    private String accepted;
    private String name;
    private double reimbursement;
    private String description;
    private Timestamp ticketTime;

    public PastTicket(int ticketid, int userid, String accepted, String name, double reimbursement, String description, Timestamp ticketTime) {

        this.ticketid = ticketid;
        this.userid = userid;
        this.accepted = accepted;
        this.name = name;
        this.reimbursement = reimbursement;
        this.description = description;
        this.ticketTime = ticketTime;
    }

    public PastTicket(int userid, String accepted, String name, double reimbursement, String description) {

        this.userid = userid;
        this.accepted = accepted;
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
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
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

        return "Tickets{" +
                "ticketid=" + ticketid +
                ", reimbursement=" + reimbursement +
                ", description='" + description + '\'' +
                ", ticketTime=" + ticketTime +
                '}';
    }
}

