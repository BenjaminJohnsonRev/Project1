package org.example.servlets;

import junit.framework.TestCase;
import org.example.dao.DaoFactory;
import org.example.dao.EmployeeDao;
import org.example.dao.PastTicketDao;
import org.example.dao.PastTicketDaoImpl;
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

public class PastTicketServletTest extends TestCase{
    PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
    EmployeeDao employeeDao = DaoFactory.getEmployeeDao();

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
            new PastTicketServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket = pastTicketDao.getByTicketid(1);
        assertEquals(ticket.getUserid(), 1);
        assertEquals(ticket.getStatus(),"accepted");
        assertEquals(ticket.getName(), "name 1");
        assertEquals(ticket.getReimbursement(), 1.0);
        assertEquals(ticket.getDescription(), "test 1");


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
            new PastTicketServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket1 = pastTicketDao.getByTicketid(1);
        assertEquals(ticket1.getUserid(), 1);
        assertEquals(ticket1.getStatus(),"accepted");
        assertEquals(ticket1.getName(), "name 1");
        assertEquals(ticket1.getReimbursement(), 1.0);
        assertEquals(ticket1.getDescription(), "test 1");

        Ticket ticket2 = pastTicketDao.getByTicketid(2);
        assertEquals(ticket2.getUserid(), 1);
        assertEquals(ticket2.getStatus(),"rejected");
        assertEquals(ticket2.getName(), "name 2");
        assertEquals(ticket2.getReimbursement(), 2.0);
        assertEquals(ticket2.getDescription(), "test 2");

        Ticket ticket = pastTicketDao.getByTicketid(3);
        assertEquals(ticket.getUserid(), 2);
        assertEquals(ticket.getStatus(),"accepted");
        assertEquals(ticket.getName(), "name 3");
        assertEquals(ticket.getReimbursement(), 3.0);
        assertEquals(ticket.getDescription(), "test 3");
    }

    @Test
    public void testDoPost() throws IOException {
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // configure/mocking the id query parameter (id = 1):
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("check")).thenReturn("true");

        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        // create a new book servlet and do the get method:
        try {
            new PastTicketServlet().doPost(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket1 = pastTicketDao.getByTicketid(4);
        assertEquals(ticket1.getUserid(), 1);
        assertEquals(ticket1.getStatus(),"accepted");
        assertEquals(ticket1.getName(), "name 1");
        assertEquals(ticket1.getReimbursement(), 1.0);
        assertEquals(ticket1.getDescription(), "test 1");
    }
}
