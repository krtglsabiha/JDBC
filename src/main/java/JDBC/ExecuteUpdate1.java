package JDBC;

import java.sql.*;

public class ExecuteUpdate1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //ExecuteUpdate() is being used for operations:INSERT, UPDATE , DELETE.

        // Step 1: Specified my Driver for DB
        Class.forName("org.postgresql.Driver");

        // Step 2: Get the Connection
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mahraba_27");

        // Step 3: Create the Statement
        Statement statement = connection.createStatement();

        System.out.println("******** TASK 1 ********");
        // Task 1: Find the companies that has less number_of_employees than the average number_of_employees in the table, and set it to 18000
        String query1="UPDATE companies SET number_of_employees = 18000 WHERE number_of_employees < (SELECT AVG(number_of_employees)FROM companies)";
        int updateRowCount=statement.executeUpdate(query1);
        System.out.println("Update Row Count: "+ updateRowCount);


        System.out.println("******** TASK 2 ********");
        // Task 2: Add another company to the companies table.
       // String query2="INSERT INTO companies (company_id, company, number_of_employees) VALUES(104, 'Oracle', 8000)";
      //  int updateRowCount2=statement.executeUpdate(query2);
      //  System.out.println("Update Row Count2: " + updateRowCount2);


        System.out.println("******** TASK 3 ********");
        //Task 3:Remove the company with ID:100
        String query3="DELETE FROM companies WHERE company_id =100;";
        int updateRowCount3=statement.executeUpdate(query3);
        System.out.println("Update Row Count: "+ updateRowCount3);


        // Step 5: Close the Statement and Connection
        statement.close();
        connection.close();

    }
}
