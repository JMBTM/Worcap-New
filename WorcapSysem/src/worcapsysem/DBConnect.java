package worcapsysem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.*;

public class DBConnect {
    private final String host = "jdbc:mysql://192.168.0.24:3306/worcap";
    private final String uName = "michael";
    private final String pass = "michael123";
    
    private Connection con;
    private Statement s;
    
    public DBConnect(){
        connect();
    }
    public String getDBHost(){
        return host;
    }
    public String getDBUname(){
        return uName;
    }
    public String getDBPas(){
        return pass;
    }
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(host, uName, pass);
            s = (Statement) con.createStatement();
        }catch(ClassNotFoundException | SQLException err){
            System.out.println("There's an error! " + err);
        }
    }
    public Connection getConnection() throws SQLException{
        return con;
    }
}
