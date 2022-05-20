package org.example.dao;

import junit.framework.TestCase;
import org.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImplTest extends TestCase {

    Connection connection = ConnectionFactory.getConnection();
    EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
    EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

    @BeforeEach
    public void setUp() {
        employeeDao.initTables();
        employeeDao.fillTables();
    }
    @Test
    public void testInitTables(){
        assertNotNull(employeeDao.getEmployeeByid(1));
    }
    @Test
    public void testFillTables(){
        assertNotNull(employeeDao.getEmployeeByid(1));
    }
    @Test
    public void testGetEmployee() {
        String sql = "select * from employee where userid = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an employee from this query
            if (resultSet.next()) {
                Employee employee = employeeDaoImpl.getEmployee(resultSet);

                assertNotNull(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsert() {
        Employee employee = new Employee("tim","tim");
        employeeDao.insert(employee);
        Employee employee2 = employeeDao.getEmployeeByCredentials("tim","tim");
        assertTrue(employee2.getUsername().equals("tim") && employee2.getPassword().equals("tim"));
    }
    @Test
    public void testGetEmployeeByCredentials() {
        Employee employee = employeeDao.getEmployeeByCredentials("name 6", "password 1");
        assertNotNull(employee);
    }
    @Test
    public void testGetEmployeeByid() {
        Employee employee = employeeDao.getEmployeeByid(1);
        assertTrue(employee.getUsername().equals("name 1") && employee.getPassword().equals("password 1"));
    }

}