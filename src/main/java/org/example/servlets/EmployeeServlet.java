package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Employee;
import org.example.services.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmplyeeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Employee payload = mapper.readValue(req.getInputStream(), Employee.class);

            //todo not actual login
            Login.validateLogin(payload);

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
            Employee payload = mapper.readValue(req.getInputStream(), Employee.class);

            //todo
            employeeDao.add(payload);

            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
