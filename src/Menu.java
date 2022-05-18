import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu {

    /**
     * Creates a new instance of Game
     * calls Game's method start() to initialize a Board and a Character
     * calls Game's method launchGame() to start playing
     * @param args
     */
    public static void main(String[] args) {
        // tester la connexion à la BDD:
        try
        {
            DBConnection connection = new DBConnection();
            Class.forName("com.mariadb.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
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

        // starting new Game
        Game newGame = new Game();
        Board board = newGame.start();
        newGame.launchGame(board);
    }
}