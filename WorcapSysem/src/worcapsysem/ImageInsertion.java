package worcapsysem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;

public class ImageInsertion {
    
    private final DBConnect db = new DBConnect();
    private Connection con;
    
    private final ServerBaseTimeAndDate sDT = new ServerBaseTimeAndDate();
    
    public ImageInsertion() throws SQLException{
        con = db.getConnection();
    }
    
    public void insertImage(File img, FileInputStream inImg, FileInputStream inImgRes) throws ParseException{
        try{
            PreparedStatement create = con.prepareStatement("INSERT INTO Screenshot VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            create.setNull(1, 0);
            create.setBinaryStream(2,(InputStream)inImg,(int)img.length());
            create.setBlob(3,inImgRes);
            create.setString(4,sDT.getDate());
            create.setString(5, sDT.getTime());
            create.setString(6, sDT.getDateTime());
            create.setInt(7, 6);
            create.setString(8, "00-10");
            create.setInt(9, 0);
            create.setInt(10, 1);
            create.setInt(11, 1);
            create.setString(12, "100% Online");
            create.setInt(13, 0);
            create.setInt(14, 0);
            create.setInt(15, 1);
            create.setString(16, "New");
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
