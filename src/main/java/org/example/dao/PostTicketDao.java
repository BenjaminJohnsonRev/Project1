package org.example.dao;

import org.example.entity.PostTicket;

import java.util.List;
import java.util.TreeSet;

public interface PostTicketDao {
    public void insert(int userId, String name, double reimbursement, String description);
    public PostTicket getPostTicketByTicketId(int ticketId);
    public List<PostTicket> getAllPostTickets();
    public List<PostTicket> getAllPostTicketsByUserId(int userId);
}
