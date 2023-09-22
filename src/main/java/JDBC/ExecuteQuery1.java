package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExecuteQuery1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step 1: Specified my Driver for DB
        Class.forName("org.postgresql.Driver");

        // Step 2: Get the Connection
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mahraba_27");

        // Step 3: Create the Statement
        Statement statement = connection.createStatement();

        // Step 4: Run the queries

        // Task 1: Get the country_name information from the countries with region_id between 2 and 4.
        String query1 = "SELECT country_name FROM countries WHERE region_id BETWEEN 2 AND 4";
        boolean sql1 = statement.execute(query1);
        System.out.println(sql1);

        // Get the data
        ResultSet resultSet = statement.executeQuery(query1);

        List<String> countries = new ArrayList<>();

        while (resultSet.next()){
            //System.out.println(resultSet.getString("country_name"));
            countries.add(resultSet.getString("country_name"));
        }
        System.out.println(countries);

        System.out.println("******** TASK 2 ********");
        //Task 2: Get the country_name and country_id information from countries
        String query2="SELECT country_name, country_id FROM countries WHERE region_id > 3";
        ResultSet resultSet2=statement.executeQuery(query2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("country_name") + "-----" + resultSet2.getString("country_id"));
        }

        System.out.println("************* TASK 3 *************");
        // Task 3: Get the country_name and region_id information from countries, which has region_id bigger than 3.
        String query3 = "SELECT country_name, region_id FROM countries WHERE region_id > 3";
        ResultSet resultSet3 = statement.executeQuery(query3);
        while (resultSet3.next()){
            System.out.println(resultSet3.getString("country_name") + " ---- " + resultSet3.getInt("region_id"));
        }

        System.out.println("************* TASK 4 *************");
        // Task 4: Get the company information, which has the most employees.
        String query4="SELECT * FROM companies WHERE number_of_employees IN (SELECT MAX(number_of_employees) FROM companies)";
        ResultSet resultSet4=statement.executeQuery(query4);
        while (resultSet4.next()){

            int idOfCompany = resultSet4.getInt("company_id");
            System.out.println("Company ID: "+ idOfCompany);

            String nameOfCompany = resultSet4.getString("company");
            System.out.println("Company Name: "+nameOfCompany);

            int numOfEmployees = resultSet4.getInt("number_of_employees");
            System.out.println("Number Of Employees: "+ numOfEmployees);
        }

        System.out.println("******** TASK 5 ********");
        // Task 5: Get the second-largest company information from companies
        String query5 = "SELECT * FROM companies ORDER BY number_of_employees DESC OFFSET 1 LIMIT 1";
        ResultSet resultSet5 = statement.executeQuery(query5);

        while (resultSet5.next()){
            System.out.println("Company Name: "+ resultSet5.getString("company"));
        }








        // Step 5: Close the Statement and Connection
        statement.close();
        connection.close();









    }
}
