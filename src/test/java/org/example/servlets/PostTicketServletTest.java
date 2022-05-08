package org.example.servlets;

import junit.framework.TestCase;
import org.example.dao.DaoFactory;
import org.example.dao.EmployeeDao;

import org.example.dao.PostTicketDao;
import org.example.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PostTicketServletTest extends TestCase{
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
    EmployeeDao employeeDao = DaoFactory.getEmployeeDao();

    @BeforeEach
    public void setUp() {
        postTicketDao.initTables();
        postTicketDao.fillTables();
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
            new PostTicketServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket = postTicketDao.getByTicketid(1);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=1, userid=1, status='pending', name='name 1', reimbursement=1.0, description='test 1', ticketTime="+ticket.getTicketTime()+"}"));


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
            new PostTicketServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket1 = postTicketDao.getByTicketid(1);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=1, userid=1, status='pending', name='name 1', reimbursement=1.0, description='test 1', ticketTime="+ticket1.getTicketTime()+"}"));

        Ticket ticket2 = postTicketDao.getByTicketid(2);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=2, userid=1, status='pending', name='name 2', reimbursement=2.0, description='test 2', ticketTime="+ticket2.getTicketTime()+"}"));

        Ticket ticket3 = postTicketDao.getByTicketid(3);
        assertTrue(stringWriter.toString().contains("Ticket{ticketid=3, userid=2, status='pending', name='name 3', reimbursement=3.0, description='test 3', ticketTime="+ticket3.getTicketTime()+"}"));
    }

    @Test
    public void testDoPost() throws IOException {
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // since we take in a buffered reader to read the body, we simulate it by putting
        // mock data in a local file called book.txt, this is simulating what we would put in body of the request
        FileReader fr = new FileReader("src/test/java/org/example/servlets/testPostTicket");
        BufferedReader t = new BufferedReader(fr);
        // configure the buffered reader:
        when(request.getReader()).thenReturn(t);

        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        // create a new book servlet and do the get method:
        try {
            new PostTicketServlet().doPost(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper books:
        Ticket ticket1 = postTicketDao.getByTicketid(4);
        assertEquals(ticket1.getUserid(), 1);
        assertEquals(ticket1.getStatus(),"pending");
        assertEquals(ticket1.getName(), "postedname");
        assertEquals(ticket1.getReimbursement(), 4.0);
        assertEquals(ticket1.getDescription(), "posted");
    }
}
