package org.example.dao;

import org.example.entity.Employee;
import org.example.entity.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    Connection connection;

    public ManagerDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public void insert(Manager manager) {
        // question marks are placeholders for the real values:
        String sql = "insert into manager (userid, username, password) values (DEFAULT, ?, ?);";

        try {
            // if anything goes wrong here, we will catch the exception:

            // we use our connection to prepare a statement to send to the database, pass in the string that we made, as well as a flag
            // that returns the generated keys (id)
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // fill in the values with the data from our employee object:
            preparedStatement.setString(1, manager.getUsername());
            preparedStatement.setString(2, manager.getPassword());
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
    public Manager getManagerByCredentials(String username, String password) {
        String sql = "select * from manager where username = ?, password = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the id using the id that we passed in:
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an employee from this query
            if (resultSet.next()) {
                Manager manager = getManager(resultSet);

                return manager;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Manager getManager(ResultSet resultSet) {
        try {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Manager(username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
