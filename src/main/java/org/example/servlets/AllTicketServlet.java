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
        int employeeId;
        try {
            employeeId = Integer.parseInt((req.getParameter("userId")));
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            CustomList<Ticket> postTickets = postTicketDao.getAll();
            CustomList<Ticket> pastTickets = pastTicketDao.getAll();
            pastTickets.addAll(postTickets);
            out.println("All Books:");
            for(int i = 0; i < pastTickets.length(); i++) {
                out.println(pastTickets.get(i));
            }
            return;
        }

        CustomList<Ticket> postTickets = postTicketDao.getAllByUserId(employeeId);
        CustomList<Ticket> pastTickets = pastTicketDao.getAllByUserId(employeeId);
        pastTickets.addAll(postTickets);
        CustomSort cs= new CustomSort();
        cs.sort(pastTickets);
        out.println(pastTickets);

    }

}
