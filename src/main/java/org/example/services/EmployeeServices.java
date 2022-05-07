//package org.example.services;
//
//import org.example.dao.DaoFactory;
//import org.example.dao.PastTicketDao;
//import org.example.dao.PostTicketDao;
//import org.example.entity.Employee;
//
//import java.util.List;
//import java.util.Scanner;
//
//import static org.example.entity.UserFactory.makeNewUser;
//
//public class EmployeeServices {
//
//    //LogsDao logsDao = DaoFactory.getLogsDao();
//
//
//    //TODO changed to get tickets by employee id instead of name
//    //passes the employee id in as the input for getting tickets
//    public void viewMyPastTickets(Employee employee){
//        PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
//        System.out.println(pastTicketDao.getAllPastTicketsById(employee.getId()));
//    }
//
//    public void viewMyPostTickets(Employee employee){
//        PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
//        System.out.println(postTicketDao.getAllPostTicketsById(employee.getId()));
//    }
//
//    public void viewAllMyTicketsByDate(Employee employee){
//        TicketServices ticketServices = new TicketServices();
//        System.out.println(TicketServices.viewTicketsByDate(employee.getId()));
//    }
//
//    public void insertEmployee(){
//        makeNewUser(false);
//    }
//
//    //TODO connect to ticket services/factory to allow employee to post a ticket for review
//    //requires price and description from user
//    public void applyForReimbursement(){
//        makeNewTicket(true);
//    }
//
//}
