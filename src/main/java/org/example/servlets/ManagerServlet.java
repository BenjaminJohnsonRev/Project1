package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.DaoFactory;
import org.example.dao.ManagerDao;
import org.example.entity.Manager;
import org.example.services.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerServlet extends HttpServlet {
    private final ManagerDao managerDao = DaoFactory.getManagerDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        try{
            //get info from postman
            ObjectMapper mapper = new ObjectMapper();
            Manager payload = mapper.readValue(req.getReader(), Manager.class);

            boolean check =  Login.validateLogin(true, payload.getUsername(),payload.getPassword());
            //create a matching manager to return info and for testing purposes
            Manager result = managerDao.getManagerByCredentials(payload.getUsername(),payload.getPassword());
            out.write(result.toString());

            if(check) {out.println("Welcome, " + payload.getUsername());}
            else {out.println("Username or password is incorrect");}

            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        try{
            ObjectMapper mapper = new ObjectMapper();
            Manager payload = mapper.readValue(req.getReader(), Manager.class);

            managerDao.insert(payload);

            Manager result = managerDao.getManagerByCredentials(payload.getUsername(),payload.getPassword());
            out.write(result.toString());

            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
