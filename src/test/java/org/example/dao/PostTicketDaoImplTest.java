package org.example.dao;

import junit.framework.TestCase;
import org.example.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostTicketDaoImplTest extends TestCase {

    Connection connection = ConnectionFactory.getConnection();
    PostTicketDao postTicketDao = DaoFactory.getPostTicketDao();
    PostTicketDaoImpl postTicketDaoImpl = new PostTicketDaoImpl();

    @BeforeEach
    public void setUp() {
        postTicketDao.initTables();
        postTicketDao.fillTables();
    }
    @Test
    public void testDelete() {
        Ticket ticket = postTicketDao.getByTicketid(1);
        postTicketDao.delete(ticket);
        assertNull(postTicketDao.getByTicketid(1));
    }
    @Test
    public void testInitTables() {
        assertNotNull(postTicketDao.getAll());
    }
    @Test
    public void testFillTables() {
        assertNotNull(postTicketDao.getAll());
    }
    @Test
    public void testInsert() {
        Ticket postTicket = new Ticket(3, "accepted", "TestName", 20.22, "test description");
        postTicketDao.insert(postTicket);
        assertNotNull(postTicketDao.getAllByUserid(3));
    }
    @Test
    public void testGetByTicketid() {
        assertTrue(postTicketDao.getByTicketid(2).getStatus().equals("pending"));
    }
    @Test
    public void testGetAll() {
        assertNotNull(postTicketDao.getAll());
    }
    @Test
    public void testGetAllByUserid() {
        assertNotNull(postTicketDao.getAllByUserid(1));
    }
    @Test
    public void testGetPostTicket() {
        String sql = "select * from postticket where userid = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an employee from this query
            if (resultSet.next()) {
                Ticket postTicket = postTicketDaoImpl.getPostTicket(resultSet);

                assertNotNull(postTicket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}