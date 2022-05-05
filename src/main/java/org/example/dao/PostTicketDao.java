package org.example.dao;

import org.example.entity.PostTicket;
import org.example.entity.Ticket;

import java.util.List;
import java.util.TreeSet;

public interface PostTicketDao {
    public void insert(Ticket ticket);
    public Ticket getByTicketId(int ticketId);
    public List<Ticket> getAll();
    public List<Ticket> getAllByUserId(int userId);
    public void delete(Ticket postTicket);
}
