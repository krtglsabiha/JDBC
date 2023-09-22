import JDBC.JDBCUtils;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
public class CountriesTestJunit {
    /*
       Given
         User connects to the database
       When
         User sends the query to get the "phone code" from "countries" table
       Then
         Verify that the number of "phone code" greater than 300 is 13.
       And
         User closes the connection
      */
    @Test
    public void countriesTest(){
        // User connects to the database
        JDBCUtils.connectToDatabase("localHost", "postgres", "postgres", "Mahraba_27");
        JDBCUtils.createStatement();
        // User sends the query to get the "phone code" from "countries" table
        List<Object> codeList = JDBCUtils.getColumnList("phone_code", "countries");
        System.out.println("codeList = " + codeList);
        //  Verify that the number of "phone code" greater than 300 is 13.
        //int numOfCodes = codeList.stream().filter(t-> (int) t > 300).collect(Collectors.toList()).size();
        int numOfCodes = (int) codeList.stream().filter(t -> (int) t > 300).count();
        System.out.println("numOfCodes = " + numOfCodes);
        // to verify
        //assertEquals(expectedValue, actualValue);
        assertEquals(13,numOfCodes);
//        assertTrue();
//        assertFalse();
        // User closes the connection
        JDBCUtils.closeStatementAndConnection();
    }
}