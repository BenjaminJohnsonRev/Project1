package org.example.services;

import org.example.dao.DaoFactory;
import org.example.dao.PastTicketDao;
import org.example.dao.PostTicketDao;
import org.example.entity.PostTicket;
import org.example.entity.Ticket;

import java.util.List;
import java.util.Scanner;

import static org.example.entity.UserFactory.makeNewUser;

public class ManagerServices {
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
    PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
    public void viewPostTickets(){

        System.out.println(postTicketDao.getAll());
    }

    public void confirmTicket(){
        System.out.println("Choose an ticket number to confirm the application: ");
        Scanner scanner = new Scanner(System.in);
        int ticketid = scanner.nextInt();

        Ticket postTicket = postTicketDao.getByTicketId(ticketid);

        pastTicketDao.insert(postTicket);
    }

    public void rejectAccount(){
        System.out.println("Choose an ticket number to deny the application: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        Ticket postTicket = postTicketDao.getByTicketId(id);

        pastTicketDao.insert(postTicket);
    }

    public void viewPastTickets(){
        PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
        System.out.println(pastTicketDao.getAll());
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
