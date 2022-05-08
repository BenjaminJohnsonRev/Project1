package org.example.servlets;

import org.example.customLists.CustomList;
import org.example.customLists.CustomSort;
import org.example.dao.DaoFactory;
import org.example.dao.PastTicketDao;
import org.example.dao.PostTicketDao;
import org.example.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class AllTicketServlet extends HttpServlet {
    PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        int employeeid;
        try {
            employeeid = Integer.parseInt((req.getParameter("id")));
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            CustomList<Ticket> postTickets = postTicketDao.getAll();
            CustomList<Ticket> pastTickets = pastTicketDao.getAll();
            pastTickets.addAll(postTickets);
            out.println("All Tickets:");
            for(int i = 0; i < pastTickets.length(); i++) {
                out.println(pastTickets.get(i));
            }
            return;
        }

        CustomList<Ticket> postTickets = postTicketDao.getAllByUserid(employeeid);
        CustomList<Ticket> pastTickets = pastTicketDao.getAllByUserid(employeeid);
        pastTickets.addAll(postTickets);
        CustomSort.sort(pastTickets);
        for(int i = 0; i < pastTickets.length(); i++) {
            out.println(pastTickets.get(i));
        }

    }

}
