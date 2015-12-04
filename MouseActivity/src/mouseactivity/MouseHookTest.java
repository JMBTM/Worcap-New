package mouseactivity;

import de.ksquared.system.mouse.GlobalMouseListener;
import de.ksquared.system.mouse.MouseAdapter;
import de.ksquared.system.mouse.MouseEvent;

public class MouseHookTest {
	public static void main(String[] args) {
            new GlobalMouseListener().addMouseListener(new MouseAdapter() {
                @Override public void mousePressed(MouseEvent event)  { System.out.println(event); }
            });
            while(true)
		try { Thread.sleep(100); }
		catch(InterruptedException e) { e.printStackTrace(); }
            }
}