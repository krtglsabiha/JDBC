package JDBC;

public class Runner {
    public static void main(String[] args) {

        // Create connection
        JDBCUtils.connectToDatabase("localHost", "postgres", "postgres", "Mahraba_27");

        // Create statement
        JDBCUtils.createStatement();

        // Execute Query
        JDBCUtils.execute("CREATE TABLE employees (employee_id INT, employee_name VARCHAR (30), employee_salary INT)");
        JDBCUtils.dropTable("employees");

        // Get the column data
        //JDBCUtils.getColumnList("country_name", "countries");

        // Close statement and connection
        JDBCUtils.closeStatementAndConnection();

    }
}