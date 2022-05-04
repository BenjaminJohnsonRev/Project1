package org.example.services;

import org.example.entity.PostTicket;

import java.util.List;
import java.util.Scanner;

import static org.example.entity.UserFactory.makeNewUser;

public class ManagerServices {
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();

    public void viewPostTickets(){

        System.out.println(postTicketDao.getAllPostTickets());
    }

    public void confirmTicket(){
        System.out.println("Choose an ticket number to confirm the application: ");
        Scanner scanner = new Scanner(System.in);
        int ticketid = scanner.nextInt();

        PostTicket postTicket = postTicketDao.getTicketById(ticketid);

        makePastTicket(true, postTicket);
    }

    public void rejectAccount(){
        System.out.println("Choose an ticket number to deny the application: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        PostTicket postTicket = postTicketsDao.getTicketById(id);

        makePastTicket(false, postTicket);
    }

    public void viewPastTickets(){
        PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
        System.out.println(pastTicketDao.getAllTickets());
    }

//    public void viewLogs(){
//
//        System.out.println("Logs: ");
//
//        LogsDao logsDao = DaoFactory.getLogsDao();
//
//        System.out.println(logsDao.getAllLogs());
//
//
//
//    }

}
