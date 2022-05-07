package org.example.dao;

import org.example.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {

    Connection connection;

    public EmployeeDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public void insert(Employee employee) {
        // question marks are placeholders for the real values:
        String sql = "insert into employee (userid, username, password) values (DEFAULT, ?, ?);";

        try {
            // if anything goes wrong here, we will catch the exception:

            // we use our connection to prepare a statement to send to the database, pass in the string that we made, as well as a flag
            // that returns the generated keys (id)
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // fill in the values with the data from our employee object:
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getPassword());
            // now that our statement is prepared, we can execute it:
            int count = preparedStatement.executeUpdate();
            if(count == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int userid = resultSet.getInt("userid");
                System.out.println("generated userid is :" + userid);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee getEmployeeByCredentials(String username, String password) {
        String sql = "select * from employee where username = ? and password = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the id using the id that we passed in:
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an employee from this query
            if (resultSet.next()) {
                Employee employee = getEmployee(resultSet);

                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int userId) {
        String sql = "select * from employee where userid = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the id using the id that we passed in:
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an employee from this query
            if (resultSet.next()) {
                Employee employee = getEmployee(resultSet);

                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee getEmployee(ResultSet resultSet) {
        try {
            int userId = resultSet.getInt("userid");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Employee(userId, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
