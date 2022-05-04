package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Ticket;
import org.example.entity.TicketFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;;

public class PastTicketServlet extends HttpServlet {
    PastTicketDao pastTicketDao = new PastTicketDao();
    PostTicketDao postTicketDao = new PostTicketDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        int employeeId;
        try{
            employeeId = Integer.parseInt((req.getParameter("userId")));
        } catch(NumberFormatException e){
            //e.printStackTrace();
            List<Ticket> pastTickets = pastTicketDao.getAll();
            out.println("Past Tickets of all employees: ");
            for(Ticket pt: pastTickets){
                out.println(pt);
            }
            return;
        }
        //todo Rory had services here, so we can replace dao with that if needed
        List<Ticket> pastTickets = pastTicketDao.getTicketsById(employeeId);
        Collections.sort(pastTickets);
        out.println(pastTickets);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketFactory ticketFactory = new TicketFactory();

        //Delete?
        PrintWriter out = resp.getWriter();


        int idToPass;
        boolean check;
        idToPass = Integer.parseInt(req.getParameter("id"));
        check = Boolean.parseBoolean(req.getParameter("check"));
        Ticket postTicket = postTicketDao.getTicketsById(idToPass);

        ticketFactory.makeAPastTicket(check,postTicket);

        try{
            ObjectMapper mapper = new ObjectMapper();
            Ticket payload = mapper.readValue(req.getInputStream(), Ticket.class);
            pastTicketDao.add(payload);
            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
