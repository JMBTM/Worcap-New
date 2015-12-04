package worcapsysem;

import java.sql.*;

public class ServerBaseTimeAndDate {
    private String result;
    private String result1;
    
    private String query;
    
    private DBConnect con = new DBConnect();
    
    private Connection con1;
    private Statement s;
    private ResultSet rs;
    
    public String getDate() throws SQLException{
        query = "SELECT CURDATE() AS 'Date Today' FROM UserLogin LIMIT 1";
        result = executeQuery(query);
        return result;
    }
    public String getTime() throws SQLException{
        query = "SELECT CURTIME() AS 'Time Today' FROM UserLogin LIMIT 1";
        result = executeQuery(query);
        return result;
    }
    public String getDateTime() throws SQLException{
        query = "SELECT NOW() as 'DateTime' FROM UserLogin LIMIT 1";
        result = executeQuery(query);
        return result;
    }
    private String executeQuery(String query) throws SQLException{
        con1 = con.getConnection();
        s = con1.createStatement();
        rs = s.executeQuery(query);
        while(rs.next()){
            result1 = rs.getString(1);
        }
        return result1;
    }
}
