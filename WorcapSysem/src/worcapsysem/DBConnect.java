package worcapsysem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
    private final String host = "jdbc:mysql://localhost:3306/worcap";
    private final String uName = "root";
    private final String pass = "";
    
    private Connection con;
    private Statement s;
    private ResultSet rs;
    
    public DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(host, uName, pass);
            s = (Statement) con.createStatement();
        }catch(ClassNotFoundException | SQLException err){
            System.out.println("There's an error!" + err);
        }
    }
}
