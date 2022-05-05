package org.example.servlets;

import junit.framework.TestCase;
import org.example.dao.DaoFactory;
import org.example.dao.EmployeeDao;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServletTest extends TestCase {

    EmployeeDao employeeDao = DaoFactory.getEmployeeDao();

    @BeforeEach
    public void setUp() {
        // since we're testing with h2, create the tables every time:
        //employeeDao.initTables();
        //employeeDao.fillTables();
    }

    @Test
    public void testDoGet() {
        // mock the request/response:
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // set up the print writer:
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        // return the writer to mimic the response's writer:
        when(response.getWriter()).thenReturn(writer);


    }

    @Test
    public void testDoPost() {
    }
}