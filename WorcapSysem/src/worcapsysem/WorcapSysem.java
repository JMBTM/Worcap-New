/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worcapsysem;

/**
 *
 * @author OJT
 */
public class WorcapSysem {

    public static void main(String[] args) throws InterruptedException, Exception {
        
        Screenshot s = new Screenshot();
        ImageInsertion imgIns = new ImageInsertion();
      
        while(true){
            s.shotAndSaveOriginal();
            imgIns.insertImage(s.getFileLocation(), s.getFileIn());
            Thread.sleep(100000);
        }
    }
    
}
