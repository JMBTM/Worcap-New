package keyboardactivities;

import java.util.EventListener;

public interface KeyListener extends EventListener {
  public void keyPressed(KeyEvent event);
  public void keyReleased(KeyEvent event);
}