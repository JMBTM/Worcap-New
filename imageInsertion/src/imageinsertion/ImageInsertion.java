package imageinsertion;

import java.sql.*;

public class ImageInsertion {
    private static Connection con;
    private static Statement s;
    private static ResultSet r;
    
    public static void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mixin", "root", "");
            s = con.createStatement();
        }catch(Exception e){
            
        }
    }
    
    public static void main(String[] args) {
       connect();
    }
    
}
