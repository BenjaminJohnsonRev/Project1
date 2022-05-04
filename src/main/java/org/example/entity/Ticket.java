package org.example.entity;

import java.sql.Timestamp;

public class Ticket implements Comparable<Ticket>{
    private int ticketId;
    private int userId;
    private String type;
    private String name;
    private double reimbursement;
    private String description;
    private Timestamp ticketTime;

    public Ticket(){

    }


    public Ticket(int ticketId, int userId, String type, String name, double reimbursement, String description, Timestamp ticketTime) {

        this.ticketId = ticketId;
        this.userId = userId;
        this.type = type;
        this.name = name;
        this.reimbursement = reimbursement;
        this.description = description;
        this.ticketTime = ticketTime;
    }

    public Ticket(int userId, String type, String name, double reimbursement, String description) {

        this.userId = userId;
        this.type = type;
        this.name = name;
        this.reimbursement = reimbursement;
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getAccepted() {
        return type;
    }

    public void setAccepted(String type) {
        this.type = type;
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
        return "PastTicket{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", reimbursement=" + reimbursement +
                ", description='" + description + '\'' +
                ", ticketTime=" + ticketTime +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        return this.ticketTime.compareTo(o.ticketTime);
    }
}
