package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.customLists.CustomList;
import org.example.customLists.CustomSort;
import org.example.dao.DaoFactory;
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

public class PostTicketServlet extends HttpServlet {
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        int employeeid;
        try{
            employeeid = Integer.parseInt((req.getParameter("id")));
        } catch(NumberFormatException e){
            CustomList<Ticket> postTickets = postTicketDao.getAll();
            out.println("Pending Tickets of all employees: ");
            out.print(postTickets);
            return;
        }
        
        CustomList<Ticket> postTickets = postTicketDao.getAllByUserid(employeeid);
        CustomSort.sort(postTickets);
        out.print(postTickets);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Ticket payload = mapper.readValue(req.getReader(), Ticket.class);
            postTicketDao.insert(payload);
            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
