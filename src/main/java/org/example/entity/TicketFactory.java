package org.example.entity;

import org.example.dao.DaoFactory;
import org.example.dao.PastTicketDao;
import org.example.dao.PostTicketDao;

import java.util.Scanner;

public class TicketFactory {
    //Takes in post ticket and approves/denies it. Finally, deleting post ticket and adding a past ticket to another table

    public static void makeAPastTicket(boolean approval, Ticket postTicket){

        int userid = postTicket.getUserid();
        String name = postTicket.getName();
        double amount = postTicket.getReimbursement();
        String desc = postTicket.getDescription();

        Ticket pastTicket;

        if(approval) {
            pastTicket = new Ticket(userid, "accepted", name, amount, desc);
        } else {
            pastTicket = new Ticket(userid, "rejected", name, amount, desc);
        }

        PostTicketDao postTicketsDao = DaoFactory.getPostTicketDao();
        PastTicketDao pastTicketsDao = DaoFactory.getPastTicketDao();
        pastTicketsDao.insert(pastTicket);
        postTicketsDao.delete(postTicket);
        System.out.println("Ticket has successfully reviewed.");
    }

}

