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

public class ManagerServlet extends HttpServlet {
    private ManagerDao managerDao = DaoFactory.getManagerDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Manager payload = mapper.readValue(req.getInputStream(), Manager.class);
            //todo not actual login
            Login.validateLogin(true, payload.getUsername(),payload.getPassword());
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
            Manager payload = mapper.readValue(req.getInputStream(), Manager.class);
            managerDao.insert(payload);
            resp.setStatus(203);
        }catch (IOException e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
