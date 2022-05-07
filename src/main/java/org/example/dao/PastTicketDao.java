package org.example.dao;

import org.example.customLists.CustomList;
import org.example.entity.PastTicket;
import org.example.entity.PostTicket;
import org.example.entity.Ticket;

import java.util.List;

public interface PastTicketDao {

    public void insert(Ticket ticket);
    public Ticket getByTicketId(int ticketId);
    public CustomList<Ticket> getAll();
    public CustomList<Ticket> getAllByUserId(int userId);

}
