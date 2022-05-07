package org.example.entity;

import org.example.dao.DaoFactory;
import org.example.dao.PastTicketDao;
import org.example.dao.PostTicketDao;

import java.util.Scanner;

public class TicketFactory {
    //creates a postTicket object then insets into postTicket table
    public static void makePostTicket(Employee employee){
        Scanner scanner = new Scanner(System.in);

        int id = employee.getUserId();

        String name = employee.getUsername();

        System.out.println("Enter reimbursement amount: ");
        double amount = scanner.nextDouble();

        System.out.println("Enter reimbursement description: ");
        String desc = scanner.nextLine();

        Ticket ticket = new Ticket(id, "ticketPending", name, amount, desc);


        //todo: not actual code
        PostTicketDao postTicketsDao = DaoFactory.getPostTicketDao();

        postTicketsDao.insert(ticket);
        System.out.println("Ticket has been posted for review.");
    }

    //Takes in post ticket and approves/denies it. Finally, deleting post ticket and adding a past ticket to another table

    public static void makeAPastTicket(boolean approval, Ticket postTicket){

        int userid = postTicket.getUserId();
        String name = postTicket.getName();
        double amount = postTicket.getReimbursement();
        String desc = postTicket.getDescription();

        Ticket pastTicket;

        if(approval) {
            pastTicket = new Ticket(userid, "ticketApproved", name, amount, desc);
        } else {
            pastTicket = new Ticket(userid, "ticketDenied", name, amount, desc);
        }

        //todo: not actual code
        PostTicketDao postTicketsDao = DaoFactory.getPostTicketDao();
        PastTicketDao pastTicketsDao = DaoFactory.getPastTicketDao();
        pastTicketsDao.insert(pastTicket);
        postTicketsDao.delete(postTicket);
        System.out.println("Ticket has successfully reviewed.");
    }

}

