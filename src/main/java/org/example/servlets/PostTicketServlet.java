package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class PostTicketServlet extends HttpServlet {
    PostTicketDao postTicketDao = new PostTicketDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        int employeeId;
        try{
            employeeId = Integer.parseInt((req.getParameter("userId")));
        } catch(NumberFormatException e){
            //e.printStackTrace();
            List<Ticket> postTickets = postTicketDao.getAll();
            out.println("Pending Tickets of all employees: ");
            for(Ticket pt: postTickets){
                out.println(pt);
            }
            return;
        }
        //todo Rory had services here, so we can replace dao with that if needed
        
        List<Ticket> postTickets = postTicketDao.getTicketsById(employeeId);
        Collections.sort(postTickets);
        out.println(postTickets);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Ticket payload = mapper.readValue(req.getInputStream(), Ticket.class);
            postTicketDao.add(payload);
            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
