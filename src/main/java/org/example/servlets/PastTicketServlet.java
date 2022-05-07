package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.customLists.CustomList;
import org.example.customLists.CustomSort;
import org.example.dao.DaoFactory;
import org.example.dao.PastTicketDao;
import org.example.dao.PostTicketDao;
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
    PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        int employeeId;
        try{
            employeeId = Integer.parseInt((req.getParameter("id")));
        } catch(NumberFormatException e){
            //e.printStackTrace();
            CustomList<Ticket> pastTickets = pastTicketDao.getAll();
            out.println("Past Tickets of all employees: ");
            for(int i = 0; i < pastTickets.length(); i++){
                out.println(pastTickets.get(i));
            }
            return;
        }
        //todo Rory had services here, so we can replace dao with that if needed
        CustomList<Ticket> pastTickets = pastTicketDao.getAllByUserId(employeeId);
        CustomSort cs = new CustomSort();
        cs.sort(pastTickets);
        out.println(pastTickets);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Delete?
        PrintWriter out = resp.getWriter();


        int idToPass;
        boolean check;
        idToPass = Integer.parseInt(req.getParameter("id"));
        check = Boolean.parseBoolean(req.getParameter("check"));
        Ticket postTicket = postTicketDao.getByTicketId(idToPass);

        TicketFactory.makeAPastTicket(check,postTicket);

        try{
            ObjectMapper mapper = new ObjectMapper();
            Ticket payload = mapper.readValue(req.getInputStream(), Ticket.class);
            pastTicketDao.insert(payload);
            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
