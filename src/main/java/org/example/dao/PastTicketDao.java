package org.example.dao;

import org.example.entity.PastTicket;
import org.example.entity.PostTicket;
import org.example.entity.Ticket;

import java.util.List;

public interface PastTicketDao {

    public void insert(Ticket ticket);
    public Ticket getByTicketId(int ticketId);
    public List<Ticket> getAll();
    public List<Ticket> getAllByUserId(int userId);

}
