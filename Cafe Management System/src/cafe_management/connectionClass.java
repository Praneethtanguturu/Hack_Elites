
package cafe_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionClass 
{
    public static void main(String [] args)
    {
        Connection conn = null;
        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/mysql";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        } 
        catch (Exception e) 
        {
            System.out.println("Cannot connect to database server: " + e);
        } 
        finally 
        {
            if (conn != null) 
            {
                try 
                {
                    conn.close();
                    System.out.println("Database Connection Terminated");
                } 
                catch (Exception e) 
                {
                    System.out.println("Error closing database connection: " + e);
                }
            }
        }
    }
        
}
