package org.example.dao;

import org.example.entity.PastTicket;
import org.example.entity.PostTicket;

import java.util.List;

public interface PastTicketDao {

    public void insert(PostTicket postTicket, String accepted);
    public PastTicket getPastTicketByTicketId(int ticketId);
    public List<PastTicket> getAllPastTickets();
    public List<PastTicket> getAllPastTicketsByUserId(int userId);

}
