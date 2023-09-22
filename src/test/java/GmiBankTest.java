import JDBC.JDBCUtils;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
public class GmiBankTest {
    /*
    Given
          User connects to the database
          (Host name: gmibank.com, Database name: gmibank_db, Usename: techprodb_user, Password: Techpro_@126))
        When
          User sends the query to get the user country ids from "tp_customer" table
        Then
          Assert that number of all null user ids is 1245
        And
          User closes the connection
     */
    @Test
    public void gmiBankTest(){
        // User connects to the database
        JDBCUtils.connectToDatabase("gmibank.com", "gmibank_db","techprodb_user", "Techpro_@126");
        JDBCUtils.createStatement();
        // User sends the query to get the user ids from "tp_customer" table
        List<Object> ids = JDBCUtils.getColumnList("country_id", "tp_customer");
        System.out.println("ids = " + ids);
        //Assert that number of all null user ids is 1245
        long numOfIds = ids.stream().filter(t-> t == null).count();
        System.out.println("numOfIds = " + numOfIds);
        assertEquals(1245, numOfIds);
        // User closes the connection
        JDBCUtils.closeStatementAndConnection();
    }
}