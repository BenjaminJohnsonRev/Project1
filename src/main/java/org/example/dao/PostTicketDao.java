package org.example.dao;

import org.example.customLists.CustomList;
import org.example.entity.Ticket;

public interface PostTicketDao {
    public void insert(Ticket ticket);
    public Ticket getByTicketid(int ticketid);
    public CustomList<Ticket> getAll();
    public CustomList<Ticket> getAllByUserid(int userid);
    public void delete(Ticket postTicket);

    //Instantiate tables and fills is with dummy data.
    public void initTables();
    public void fillTables();
}
