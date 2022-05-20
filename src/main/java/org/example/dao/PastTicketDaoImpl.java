package org.example.dao;

import org.example.customLists.CustomArrayList;
import org.example.customLists.CustomList;
import org.example.entity.Ticket;

import java.sql.*;

public class PastTicketDaoImpl implements PastTicketDao{

    Connection connection;

    public PastTicketDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void insert(Ticket ticket) {
        // question marks are placeholders for the real values:
        String sql = "insert into pastticket (ticketid, userid, status, name, reimbursement, description, ticketTime)" +
                " values (DEFAULT, ?, ?, ?, ?, ?, DEFAULT);";

        try {
            // if anything goes wrong here, we will catch the exception:

            // we use our connection to prepare a statement to send to the database, pass in the string that we made, as well as a flag
            // that returns the generated keys (id)
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // fill in the values with the data from our account object:
            preparedStatement.setInt(1, ticket.getUserid());
            preparedStatement.setString(2, ticket.getStatus());
            preparedStatement.setString(3, ticket.getName());
            preparedStatement.setDouble(4, ticket.getReimbursement());
            preparedStatement.setString(5, ticket.getDescription());
            // now that our statement is prepared, we can execute it:
            // count is how many rows are affected (optimally we would have 1, we are inserting a single account)
            int count = preparedStatement.executeUpdate();
            if(count == 1) {
                System.out.println("Ticket added successfully!");
                // first, we get the result set
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                // increment to the first element of the result set
                resultSet.next();
                // extract the id from the result set
                int ticketid = resultSet.getInt(1);
                System.out.println("Generated ticket number is: " + ticketid);
            }
            else {
                System.out.println("Something went wrong when adding the account!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Ticket getByTicketid(int ticketid) {
        String sql = "select * from pastticket where ticketid = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the id using the id that we passed in:
            preparedStatement.setInt(1, ticketid);
            ResultSet resultSet = preparedStatement.executeQuery();
            // checking, do we have an account from this query
            if (resultSet.next()) {
                // extract out the data
                Ticket pastTicket = getPastTicket(resultSet);
                return pastTicket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomList<Ticket> getAll() {
        // create a list of accounts to store our results:
        CustomList<Ticket> pastTickets = new CustomArrayList<Ticket>();
        String sql = "select * from pastticket;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            // we use a while loop because there are multiple results:
            while(resultSet.next()) {
                Ticket pastTicket = getPastTicket(resultSet);
                // add account to list of accounts
                pastTickets.add(pastTicket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastTickets;
    }

    @Override
    public CustomList<Ticket> getAllByUserid(int userid) {
        // create a list of accounts to store our results:
        CustomList<Ticket> pastTickets = new CustomArrayList<Ticket>();
        String sql = "select * from pastticket where userid = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            // we use a while loop because there are multiple results:
            while(resultSet.next()) {
                Ticket pastTicket = getPastTicket(resultSet);
                // add account to list of accounts
                pastTickets.add(pastTicket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastTickets;
    }

    public Ticket getPastTicket(ResultSet resultSet) {
        try {
            int ticketid = resultSet.getInt("ticketid");
            int userid = resultSet.getInt("userid");
            String status = resultSet.getString("status");
            String name = resultSet.getString("name");
            double reimbursement = resultSet.getDouble("reimbursement");
            String description = resultSet.getString("description");
            Timestamp ticketTime = resultSet.getTimestamp("ticketTime");
            return new Ticket(ticketid, userid, status, name, reimbursement, description, ticketTime);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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

        try {
            // creating a statement instead of preparing it
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
        sql += "insert into postticket (ticketid,userid,status,name,reimbursement,description, ticketTime) values (default, 1, 'pending', 'name 1', 1.00, 'test 1', Default);\n";
        sql += "insert into pastticket (ticketid,userid,status,name,reimbursement,description, ticketTime) values (default, 1, 'accepted', 'name 1', 1.00, 'test 1', Default);\n";
        sql += "insert into pastticket (ticketid,userid,status,name,reimbursement,description, ticketTime) values (default, 1, 'rejected', 'name 2', 2.00, 'test 2', Default);\n";
        sql += "insert into pastticket (ticketid,userid,status,name,reimbursement,description, ticketTime) values (default, 2, 'accepted', 'name 3', 3.00, 'test 3', Default);\n";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
