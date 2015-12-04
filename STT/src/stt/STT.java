package stt;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class STT {

    public static void main(String[] args) {
        TrayIcon trayIcon = null;
        Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\OJT\\Documents\\John Michael\\background\\php-code.jpg");
        if (SystemTray.isSupported()) {
         // get the SystemTray instance
         SystemTray tray = SystemTray.getSystemTray();
         
         ActionListener listener = new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             }
         };
         PopupMenu popup = new PopupMenu();
         MenuItem defaultItem = new MenuItem("About");
         MenuItem defaultItem1 = new MenuItem("Exit");
         defaultItem.addActionListener(listener);
         popup.add(defaultItem);
         popup.addSeparator();
         popup.add(defaultItem1);
         
        //trayIcon.setPopupMenu(popup);
         
         defaultItem.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 JOptionPane.showMessageDialog(null, "Made by John Michael Tolentino", "This is the title of the dialog", 1);
             }
         });
         
         trayIcon = new TrayIcon(image, "Tray Demo", popup);
         trayIcon.addActionListener(listener);
         try {
             tray.add(trayIcon);
         } catch (AWTException e) {
             System.err.println(e);
         }
     } else {
         
     }
     if (trayIcon != null) {
         trayIcon.setImage(image);
     }
    }
    
}
