package worcapsysem;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;


public class Screenshot {
    
    private BufferedImage capture;
    private File img;
    private FileInputStream inImg;
    
    public void shotAndSaveOriginal() throws Exception //Screenshot processing
    {
        
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle();//Initialization of screen size
        Toolkit t = Toolkit.getDefaultToolkit();
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            
            screenRect = screenRect.union(gd.getDefaultConfiguration().getBounds()); //Join the two screen together
            
        }
        
        capture = robot.createScreenCapture(screenRect);//capture processing with the two screen combined
        ImageIO.write(capture, "JPG", img = new File("C:/Users/OJT/workspace/img.jpg")); // File Location to save
        inImg = new FileInputStream(img);
    }
    
    public BufferedImage getCapturedImage()
    {
        return capture;
    }
    
    public File getFileLocation()
    {
        return img;
    }
    
    public FileInputStream getFileIn()
    {
        return inImg;
    }
    
}
