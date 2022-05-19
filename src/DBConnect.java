import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

/*
    public void testConnectToDB(){
        // tester la connexion à la BDD:
        try
        {
            DBConnectionVariables connection = new DBConnectionVariables();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    connection.getUrl(),connection.getUser(), connection.getPassword());
            // go check : https://docs.oracle.com/javase/tutorial/essential/environment/env.html#:~:text=Like%20properties%20in%20the%20Java,also%20between%20command%20line%20interpreters.

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
*/

    public static Connection getConnection(){
        Connection con=null;
        try
        {
            DBConnectionVariables connection = new DBConnectionVariables();
            //
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    connection.getUrl(),connection.getUser(), connection.getPassword());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}
