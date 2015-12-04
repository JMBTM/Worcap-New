package mouseactivity;

public interface MouseListener extends EventListener {
    public void mouseMoved(MouseEvent event);
    public void mousePressed(MouseEvent event);
    public void mouseReleased(MouseEvent event);
}
