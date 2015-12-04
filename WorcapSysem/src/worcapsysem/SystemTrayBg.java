package worcapsysem;

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

public class SystemTrayBg {
    public SystemTrayBg() throws AWTException{
         if(!SystemTray.isSupported()){
            JOptionPane.showMessageDialog(null, "Worcap System", "Worcap", 0);
        }
        
        SystemTray tray = SystemTray.getSystemTray();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("C:/xampp/htdocs/worcap/img/logo.png");
        
        PopupMenu menu = new PopupMenu();
        
        MenuItem msgItem = new MenuItem("Close Worcap");
        
        msgItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Confirm", 0);
                if(result == 0)
                {
                    System.exit(0);
                }
                else{}
            } 
        });
        menu.add(msgItem);
        TrayIcon icon = new TrayIcon(img, "Worcap", menu);
        icon.setImageAutoSize(true);
        tray.add(icon);
    }
}
