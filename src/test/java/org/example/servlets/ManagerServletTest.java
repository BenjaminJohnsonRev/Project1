package org.example.servlets;


import junit.framework.TestCase;
import org.example.dao.DaoFactory;
import org.example.dao.ManagerDao;
import org.example.dao.ManagerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManagerServletTest extends TestCase {
    ManagerDao managerDao = DaoFactory.getManagerDao();

    @BeforeEach
    public void setUp() {
        // since we're testing with h2, create the tables every time:
        managerDao.initTables();
        managerDao.fillTables();
    }

    @Test
    public void testDoGet() throws IOException {
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // since we take in a buffered reader to read the body, we simulate it by putting
        // mock data in a local file called employee.txt, this is simulating what we would put in body of the request
        // we can reuse employee files for manager testing
        FileReader fr = new FileReader("src/test/java/org/example/servlets/testEmployee");
        BufferedReader t = new BufferedReader(fr);
        // configure the buffered reader:
        when(request.getReader()).thenReturn(t);
        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        // create a new employee servlet and do the get method:
        try {
            new ManagerServlet().doGet(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper fields:
        assertTrue(stringWriter.toString().contains("Manager{username='name 1', password='password 1'}"));
    }

    @Test
    public void testDoPost() throws IOException{
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // since we take in a buffered reader to read the body, we simulate it by putting
        // mock data in a local file called employee.txt, this is simulating what we would put in body of the request
        // we can reuse employee files for manager testing
        FileReader fr = new FileReader("src/test/java/org/example/servlets/testPostEmployee");
        BufferedReader t = new BufferedReader(fr);
        // configure the buffered reader:
        when(request.getReader()).thenReturn(t);

        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        // create a new employee servlet and do the get method:
        try {
            new ManagerServlet().doPost(request, response);
        } catch(ServletException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        // flush the writer, make sure all the output is written:
        writer.flush();
        // assert that the result contains all of the proper employees:
        assertTrue(stringWriter.toString().contains("Manager{username='name 4', password='password 4'}"));
    }
}
