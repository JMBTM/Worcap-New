package javaapplication1;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;

public class Screenshot {
    //private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
    //private Calendar now = Calendar.getInstance();
    static int width;
    static int height;
    static double alpha = 2;
    static double beta = 50;
    
    public void shotAndSaveOriginal() throws Exception //Screenshot processing
    {
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle();//Initialization of screen size
        
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            
            screenRect = screenRect.union(gd.getDefaultConfiguration().getBounds()); //Join the two screen together
        
        }
        
        BufferedImage capture = robot.createScreenCapture(screenRect);//capture processing with the two screen combined
        ImageIO.write(capture, "JPG", new File("C:/Users/OJT/workspace/img.png")); // File Location to save
    }
    
    public void compressImage() throws Exception{
        File input = new File("C:/Users/OJT/workspace/compress.png"); //Location of the captured image
        BufferedImage image = ImageIO.read(input); //Image reading

        File compressedImageFile = new File("C:/Users/OJT/workspace/compress1.png");//Future File Location to be saved
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(1f);
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }
    
    public void decompressImage() throws Exception{
        File imageLocation = new File("C:/Users/OJT/workspace/compress.jpg");
        BufferedImage image = ImageIO.read(imageLocation);
        
        File incompressImage = new File("C:/Users/OJT/workspace/incompress.jpg");//Future File Location to be saved
        OutputStream os = new FileOutputStream(incompressImage);
        
        Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.unsetCompression();
        param.unsetTiling();
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }
    public void decompressImage1(){
        try {
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         Mat source = Highgui.imread("C:/Users/OJT/workspace/compress.jpg", 
         Highgui.CV_LOAD_IMAGE_GRAYSCALE);
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         
         Imgproc.equalizeHist(source, destination);
         Highgui.imwrite("C:/Users/OJT/workspace/contrast.jpg", destination);
         
        }catch (Exception e) {
         System.out.println("error: " + e.getMessage());
        }
    }
}
