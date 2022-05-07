package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.DaoFactory;
import org.example.dao.EmployeeDao;
import org.example.entity.Employee;
import org.example.services.Login;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet extends HttpServlet {
    private EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Employee payload = mapper.readValue(req.getReader(), Employee.class);

            Login.validateLogin(false, payload.getUsername(), payload.getPassword());

            Employee result = employeeDao.getEmployeeByCredentials(payload.getUsername(),payload.getPassword());
            PrintWriter out = resp.getWriter();
            out.write(result.toString());

            //System.out.println(result);
            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Employee payload = mapper.readValue(req.getReader(), Employee.class);
            System.out.println("Here 2!");

            employeeDao.insert(payload);
            //accepts username and password
            Employee result = employeeDao.getEmployeeByCredentials(payload.getUsername(), payload.getPassword());
            PrintWriter out = resp.getWriter();
            out.write(result.toString());
            System.out.println(result);

            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
