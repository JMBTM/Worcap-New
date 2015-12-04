package worcapsysem;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResizeImageToThumbnail {
    
    private File f;
    private FileInputStream fIn;
    private static final int width = 200;
    private static final int height= 200;
    
    public void saveAndResizeImg(File f) throws IOException{
        BufferedImage img = ImageIO.read(f);
        int type = img.getType();
        resizedImg(img, type, f);
    }
    private static BufferedImage resizeImg(BufferedImage img, int type){
        BufferedImage resizedImg = new BufferedImage(width, height, type);
        Graphics2D g = resizedImg.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        
        return resizedImg;
    }
    private static BufferedImage resizeImageWithHint(BufferedImage img, int type){
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        return resizedImage;
    }
    
    private void resizedImg(BufferedImage img, int type, File f) throws IOException{
        BufferedImage resizedImage = resizeImg(img, type);
        ImageIO.write(resizedImage, "jpg", f = new File(f.getAbsoluteFile().getParent() + "/resizedImg.jpg"));
        fIn = new FileInputStream(f);
    }
    public FileInputStream getFileInRes(){
        return fIn;
    }
    public File returnFileRes(){
        return f;
    }
}
