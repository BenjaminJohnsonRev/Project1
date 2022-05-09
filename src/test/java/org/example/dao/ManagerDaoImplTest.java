package org.example.dao;

import junit.framework.TestCase;
import org.example.entity.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImplTest extends TestCase {
    Connection connection = ConnectionFactory.getConnection();
    ManagerDao managerDao = DaoFactory.getManagerDao();
    ManagerDaoImpl managerDaoImpl = new ManagerDaoImpl();

    @BeforeEach
    public void setUp() {
        managerDao.initTables();
        managerDao.fillTables();
    }
    @Test
    public void testInitTables() {
        assertNotNull(managerDao.getManagerByCredentials("name 1", "password 1"));
    }
    @Test
    public void testFillTables() {
        assertNotNull(managerDao.getManagerByCredentials("name 1", "password 1"));
    }

    @Test
    public void testInsert() {
        Manager manager = new Manager("tim", "tim");
        managerDao.insert(manager);
        Manager manager2 = managerDao.getManagerByCredentials("tim", "tim");
        assertTrue(manager2.getUsername().equals("tim") && manager2.getPassword().equals("tim"));
    }
    @Test
    public void testGetManagerByCredentials() {
        Manager manager = managerDao.getManagerByCredentials("name 1", "password 1");
        assertNotNull(manager);
    }

    @Test
    public void testGetManager() {
        String sql = "select * from manager where username = 'name 1';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an manager from this query
            if (resultSet.next()) {
                Manager manager = managerDaoImpl.getManager(resultSet);

                assertNotNull(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}