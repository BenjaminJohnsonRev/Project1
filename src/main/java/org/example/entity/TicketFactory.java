package org.example.entity;

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
        PostTicketsDao postTicketsDao = DaoFactory.getPostTicketDao();
        postTicketsDao.add(ticket);
        System.out.println("Ticket has been posted for review.");
    }

    //Takes in post ticket and approves/denies it. Finally, deleting post ticket and adding a past ticket to another table
    public static void makeAPastTicket(boolean approval, Ticket postTicket){

        int id = postTicket.getTicketId();
        String name = postTicket.getName();
        Double amount = postTicket.getReimbursement();
        String desc = postTicket.getDescription();
        Ticket pastTicket;

        if(approval) {
            pastTicket = new Ticket(id, "ticketApproved", name, amount, desc);
        } else {
            pastTicket = new Ticket(id, "ticketDenied", name, amount, desc);
        }

        //todo: not actual code
        PostTicketsDao postTicketsDao = DaoFactory.getPostTicketDao();
        PastTicketsDao pastTicketsDao = DaoFactory.getPastTicketDao();
        postTicketsDao.delete(postTicket);
        pastTicketsDao.add(pastTicket);
        System.out.println("Ticket has successfully reviewed.");
    }
}
