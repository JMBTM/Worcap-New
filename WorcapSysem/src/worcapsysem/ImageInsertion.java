package worcapsysem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class ImageInsertion {
    
    private final String host = "jdbc:mysql://localhost:3306/worcap";//host for server and name of the database for connection
    private final String uName = "root";
    private final String pass = "";
    private com.mysql.jdbc.Connection con;
    private com.mysql.jdbc.Statement s;
    private ResultSet rs;
    
    public ImageInsertion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(host, uName, pass);
            s = (com.mysql.jdbc.Statement) con.createStatement();
        }catch(ClassNotFoundException | SQLException err){
            System.out.println("There's an error!" + err);
        }
    }
    
    public void insertImage(File img, FileInputStream inImg){
        
        try{
            
            PreparedStatement create = con.prepareStatement("INSERT INTO Screenshot(Img, Message, Date, Time, DateAndTime, LevelTime, EmployeeID, ProjectID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            create.setBinaryStream(1,(InputStream)inImg,(int)img.length());
            create.setString(2, "This is just a demo!");
            create.setNull(3, 0);
            create.setNull(4, 0);
            create.setNull(5, 0);
            create.setString(6, "00-10");
            create.setInt(7, 1);
            create.setInt(8, 1);
            create.executeUpdate();
            create.close();
            
        }catch(SQLException e){
            System.out.println(e);
        }
        finally{
            System.out.println("Successfully insert the image");
        }
    }
    
    
    
}
