package game;

public class DBConnectionVariables {

    private String url = "jdbc:mysql://localhost:3306/dungeonDB";
    private String user = "diane";
    private String password="bdd456mp*moi";

    public String getUrl(){
        return this.url;
    }
    public String getUser(){
        return this.user;
    }
    public String getPassword(){
        return this.password;
    }
}
