package javaapplication1;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class JavaApplication1 {
    
    public static void main(String[] args) throws Exception {
        
        Screenshot screenshot = new Screenshot();
        
        screenshot.shotAndSaveOriginal();
        screenshot.compressImage();
        //screenshot.decompressImage1();
        
        /*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        for (GraphicsDevice gd : gs) {
            GraphicsConfiguration[] gc =
                    gd.getConfigurations();
            System.out.println(gc.length);
            /*for (int i=0; i < gc.length; i++) {
            JFrame f = new
            JFrame(gs[j].getDefaultConfiguration());
            Canvas c = new Canvas(gc[i]);
            Rectangle gcBounds = gc[i].getBounds();
            int xoffs = gcBounds.x;
            int yoffs = gcBounds.y;
            f.getContentPane().add(c);
            f.setLocation((i*50)+xoffs, (i*60)+yoffs);
            f.show();
            }
        }*/
        
    }
    
}
