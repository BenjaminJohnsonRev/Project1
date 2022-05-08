package org.example.dao;

import org.example.entity.Employee;

import java.sql.*;

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
        String sql = "select * from employee where username = ? AND password = ?;";
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
    public Employee getEmployeeByid(int userid) {
        String sql = "select * from employee where userid = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the id using the id that we passed in:
            preparedStatement.setInt(1, userid);
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

    // we need this method if we're using an h2 database, keep in mind that our database gets "reset" every time, we run the program
    @Override
    public void initTables() {
        // we don't see any ? placeholders because this statement will be the same every time
        String sql = "DROP TABLE IF EXISTS pastticket; " +
                "DROP TABLE IF EXISTS postticket;" +
                "DROP TABLE IF EXISTS employee; CREATE TABLE employee(userid SERIAL PRIMARY KEY, username VARCHAR(50), password varchar(50));" +
                "create table postticket (ticketid serial primary key, userid int, status varchar, name varchar, reimbursement float, description varchar, ticketTime TimeStamp default current_timestamp," +
                "foreign key (userid) references employee(userid));" +
                "create table pastticket (ticketid serial primary key, userid int, status varchar, name varchar, reimbursement float, description varchar, ticketTime TimeStamp default current_timestamp," +
                "foreign key (userid) references employee(userid));";

        // we could add a procedure as well as so we can test it with h2
        try {
            // creating a statement instead of preparinf it
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillTables() {
        String sql = "insert into employee(userid, username, password) values (default, 'name 1', 'password 1');\n";
        sql += "insert into employee(userid, username, password) values (default, 'name 2', 'password 2');\n";
        sql += "insert into employee(userid, username, password) values (default, 'name 3', 'password 3');";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public Employee getEmployee(ResultSet resultSet) {
        try {
            int userid = resultSet.getInt("userid");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Employee(userid, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
