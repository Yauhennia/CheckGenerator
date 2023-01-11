import java.sql.*;


public class ConnectionToDB {

    private String dbName = "flower_shop_db";
    private String dbUser = "postgres";
    private String dbPassword = "admin";
    private String dbURL = "jdbc:postgresql://localhost:5432/";
    public ConnectionToDB(){
    }

    public ConnectionToDB(String dbName, String dbUser, String dbPassword) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, dbUser, dbPassword);
            if(conn != null) {
                //System.out.println("Connection Established!");
            }
            else {
                System.out.println("Connection Failed!");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public Connection connect(){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(dbURL + dbName, dbUser, dbPassword);
            if(conn != null) {
                //System.out.println("Connection Established!");
            }
            else {
                System.out.println("Connection Failed!");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }



    public void setDbConnection(String dbURL, String dbName, String dbUser, String dbPassword) {
        this.dbURL = dbURL;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

}
