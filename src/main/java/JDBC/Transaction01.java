package JDBC;

import java.sql.*;

public class Transaction01 {
    public static void main(String[] args) throws SQLException {

        // Create Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Swar2005!");
        // Create Statement
        Statement statement = con.createStatement();

        // Task 1: Using preparedstatement, delete students who are from Computer Eng department, from students table.
        String query1 = "DELETE FROM students WHERE department ILIKE ? "; // Normal Query
        PreparedStatement ps2 = con.prepareStatement(query1);

        ps2.setString(1, "Comp.Eng.");
        ps2.executeUpdate();

        // Get the control of transaction
        con.setAutoCommit(false);  // we are controlling the auto shipping by declaring it false

        if (true){
            con.rollback();
        }
        // we allow the shipping now (committing)
        con.commit();

        // Close connection and statement
        statement.close();
        con.close();

    }
}