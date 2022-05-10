package org.example.servlets;

import junit.framework.TestCase;
import org.example.dao.*;
import org.example.entity.Employee;

import org.example.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AllTicketServletTest extends TestCase{
    PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();

    @BeforeEach
    public void setUp() {
        pastTicketDao.initTables();
        pastTicketDao.fillTables();
    }

    @Test
    public void testDoGet() throws IOException {
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // configure/mocking the id query parameter (id = 1):
        when(request.getParameter("id")).thenReturn("1");

        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        // create a new book servlet and do the get method:
        try {
            new AllTicketServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        Ticket ticket = pastTicketDao.getByTicketid(1);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=1, userid=1, status='accepted', name='name 1', reimbursement=1.0, description='test 1', ticketTime="+ticket.getTicketTime()+"}"));

        Ticket ticket1 = postTicketDao.getByTicketid(1);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=1, userid=1, status='pending', name='name 1', reimbursement=1.0, description='test 1', ticketTime="+ticket1.getTicketTime()+"}"));

    }

    @Test
    public void testDoGetAll() throws IOException {
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);


        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        // create a new book servlet and do the get method:
        try {
            new AllTicketServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket1 = pastTicketDao.getByTicketid(1);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=1, userid=1, status='accepted', name='name 1', reimbursement=1.0, description='test 1', ticketTime="+ticket1.getTicketTime()+"}"));

        Ticket ticket2 = pastTicketDao.getByTicketid(2);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=2, userid=1, status='rejected', name='name 2', reimbursement=2.0, description='test 2', ticketTime="+ticket2.getTicketTime()+"}"));

        Ticket ticket3 = pastTicketDao.getByTicketid(3);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=3, userid=2, status='accepted', name='name 3', reimbursement=3.0, description='test 3', ticketTime="+ticket3.getTicketTime()+"}"));

        Ticket ticket4 = postTicketDao.getByTicketid(1);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=1, userid=1, status='pending', name='name 1', reimbursement=1.0, description='test 1', ticketTime="+ticket4.getTicketTime()+"}"));
    }
}
