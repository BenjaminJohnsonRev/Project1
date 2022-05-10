package org.example.dao;

import org.example.customLists.CustomList;
import org.example.entity.Ticket;

public interface PastTicketDao {

    public void insert(Ticket ticket);
    public Ticket getByTicketid(int ticketid);
    public CustomList<Ticket> getAll();
    public CustomList<Ticket> getAllByUserid(int userid);

    //Instantiate tables and fills is with dummy data.
    public void initTables();
    public void fillTables();
}
