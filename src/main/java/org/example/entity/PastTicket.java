package org.example.entity;

import java.sql.Timestamp;

public class PastTicket {
    private int ticketId;
    private int userId;
    private String accepted;
    private String name;
    private double reimbursement;
    private String description;
    private Timestamp ticketTime;

    public PastTicket(int ticketId, int userId, String accepted, String name, double reimbursement, String description, Timestamp ticketTime) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.accepted = accepted;
        this.name = name;
        this.reimbursement = reimbursement;
        this.description = description;
        this.ticketTime = ticketTime;
    }

    public PastTicket(int userId, String accepted, String name, double reimbursement, String description) {
        this.userId = userId;
        this.accepted = accepted;
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
                "ticketId=" + ticketId +
                ", reimbursement=" + reimbursement +
                ", description='" + description + '\'' +
                ", ticketTime=" + ticketTime +
                '}';
    }
}
