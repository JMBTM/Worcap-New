/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdetector;
import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author OJT
 */
public class AppDetector extends Applet{
    public Choice choice;
    
    public void init(){
        setFont(new Font("Helvetica", Font.BOLD, 36));
        choice = new Choice();
    }
    
    public static void main(String[] args) {
        AppDetector appd = new AppDetector();
        appd.run();
    }
     List<String> processList = new ArrayList<String>();

    public void run() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("C:\\server.bat");
            process.getOutputStream().close();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(
                    inputStream);
            BufferedReader bufferedrReader = new BufferedReader(
                    inputstreamreader);
            BufferedReader bufferedrReader1 = new BufferedReader(
                    inputstreamreader);

            String strLine = "";
            String x[]=new String[100];
            int i=0;
            int t=0;
            while ((strLine = bufferedrReader.readLine()) != null) 
            {
        //      System.out.println(strLine);
                String[] a=strLine.split(",");
                x[i++]=a[0];
            }
    //      System.out.println("Length : "+i);

            for(int j=2;j<i;j++)
            {
                System.out.println(x[j]);
            }
        }
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        }
    }
}
