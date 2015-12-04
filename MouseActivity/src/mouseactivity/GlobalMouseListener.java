package mouseactivity;

import java.util.List;
import java.util.Vector;

public class GlobalMouseListener {
	protected PoolHook hook;
	public GlobalMouseListener() { (hook=new PoolHook(this)).start();	}
	protected List<MouseListener> listeners = new Vector<MouseListener>();

	public void addMouseListener(MouseListener listener) { listeners.add(listener); }
	public void removeMouseListener(MouseListener listener) { listeners.remove(listener); }

	void mouseMoved(MouseEvent event) {
		try {
			for(MouseListener listener:listeners)
				listener.mouseMoved(event);
		} catch(Exception e) { e.printStackTrace(); }
	}
	void mousePressed(MouseEvent event) {
		try {
			for(MouseListener listener:listeners)
				listener.mousePressed(event);
		} catch(Exception e) { e.printStackTrace(); }
	}
	void mouseReleased(MouseEvent event) {
		try {
			for(MouseListener listener:listeners)
				listener.mouseReleased(event);
		} catch(Exception e) { e.printStackTrace(); }
	}
}
