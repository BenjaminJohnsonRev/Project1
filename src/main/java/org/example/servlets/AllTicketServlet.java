package org.example.servlets;

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
    PastTicketDao pastTicketDao = new PastTicketDao();
    PostTicketDao postTicketDao = new PostTicketDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        int employeeId;
        try {
            employeeId = Integer.parseInt((req.getParameter("userId")));
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            List<Ticket> postTickets = postTicketDao.getAll();
            List<Ticket> pastTickets = pastTicketDao.getAll();
            pastTickets.addAll(postTickets);
            out.println("All Books:");
            for(Ticket t: pastTickets) {
                out.println(t);
            }
            return;
        }

        List<Ticket> postTickets = postTicketDao.getTicketsbyId(employeeId);
        List<Ticket> pastTickets = pastTicketDao.getTicketsbyId(employeeId);
        pastTickets.addAll(postTickets);
        Collections.sort(pastTickets);
        out.println(pastTickets);

    }

}
