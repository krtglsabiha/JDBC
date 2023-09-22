import JDBC.JDBCUtils;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesTest {
    // Gherkin Language

        /*
           Given   --> pre-condition, pre-requisite
             User connects to the database
           And
           When    --> task / action
             User sends the query to get the region ids from "countries" table
             And
           Then  -- get the result and verify it
             Verify that the number of region ids greater than 10 is 40.
           And  --> to avoid repetition of Given, When or Then, we use And
             User closes the connection
          */

    public static void main(String[] args) throws SQLException {
        // User connects to the database
        // jdbc:postgresql://localhost:5432/postgres", "postgres", "Mahraba_27!
        JDBCUtils.connectToDatabase("localHost", "postgres", "postgres", "Mahraba_27");
        JDBCUtils.createStatement();

        //  User sends the query to get the region ids from "countries" table
        String query = "SELECT id FROM countries";
        ResultSet resultSet = JDBCUtils.statement.executeQuery(query);

        List<Integer> idList = new ArrayList<>();

        while (resultSet.next()){
            idList.add(resultSet.getInt("id"));
        }
        System.out.println("idList = " + idList);

        // Verify that the number of region ids greater than 10 is 40
        int counter = 0;
        for (int w: idList){
            if (w>10){
                counter++;
            }
        }
        System.out.println("counter = " + counter);

    }
}