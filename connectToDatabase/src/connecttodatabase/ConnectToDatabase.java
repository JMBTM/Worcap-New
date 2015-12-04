package connecttodatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class ConnectToDatabase{

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
    
    public static void DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mixin", "root", "");
            st = con.createStatement();
        }catch(ClassNotFoundException | SQLException err){
            System.out.println(err);
        }
        
    }
    
    public static void cTable() throws Exception {
        try{

            PreparedStatement create = con.prepareStatement("INSERT INTO users(Username, Password, Email) VALUES('Demo','Demo','Demo@email.com')");
            create.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e);
        }
        finally{
            System.out.println("Inserting values to the table has been done!");
        }
    }
    
    public static void getData(){
        try{
            String query = "SELECT * FROM users";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String name = rs.getString("Username");
                String pass = rs.getString("Password");
                System.out.println("Username: " + name + "\t Password: " + pass);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    } 
    
    public static void main(String[] args) throws Exception {
        DBConnect();
        //cTable();
        getData();
        try {
        String line;
        Process p = Runtime.getRuntime().exec("tasklist.exe");
        BufferedReader input =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            System.out.println(line); //<-- Parse data here.
        }
        input.close();
    } catch (Exception err) {
        err.printStackTrace();
    }
    }
}