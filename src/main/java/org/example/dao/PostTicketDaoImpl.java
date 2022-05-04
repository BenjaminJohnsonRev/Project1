package org.example.dao;

import org.example.entity.PostTicket;

import java.util.List;

public class PostTicketDaoImpl implements PostTicketDao{
    @Override
    public void insert(int userId, String name, double reimbursement, String description) {


    }

    @Override
    public PostTicket getPostTicketByTicketId(int ticketId) {
        return null;
    }

    @Override
    public List<PostTicket> getAllPostTickets() {
        return null;
    }

    @Override
    public List<PostTicket> getAllPostTicketsByUserId(int userId) {
        return null;
    }
}
