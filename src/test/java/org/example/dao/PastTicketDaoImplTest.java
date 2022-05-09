package org.example.dao;

import junit.framework.TestCase;
import org.example.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PastTicketDaoImplTest extends TestCase {
    Connection connection = ConnectionFactory.getConnection();
    PastTicketDao pastTicketDao = DaoFactory.getPastTicketDao();
    PastTicketDaoImpl pastTicketDaoImpl = new PastTicketDaoImpl();

    @BeforeEach
    public void setUp() {
        pastTicketDao.initTables();
        pastTicketDao.fillTables();
    }
    @Test
    public void testInitTables() {
        assertNotNull(pastTicketDao.getAll());
    }
    @Test
    public void testFillTables() {
        assertNotNull(pastTicketDao.getAll());
    }
    @Test
    public void testInsert() {
        Ticket pastTicket = new Ticket(3, "accepted", "TestName", 20.22, "test description");
        pastTicketDao.insert(pastTicket);
        assertNotNull(pastTicketDao.getAllByUserid(3));
    }
    @Test
    public void testGetByTicketid() {
        assertTrue(pastTicketDao.getByTicketid(2).getStatus().equals("rejected"));
    }
    @Test
    public void testGetAll() {
        assertNotNull(pastTicketDao.getAll());
    }
    @Test
    public void testGetAllByUserid() {
        assertNotNull(pastTicketDao.getAllByUserid(1));
    }
    @Test
    public void testGetPastTicket() {
        String sql = "select * from pastticket where userid = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an employee from this query
            if (resultSet.next()) {
                Ticket pastTicket = pastTicketDaoImpl.getPastTicket(resultSet);

                assertNotNull(pastTicket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}