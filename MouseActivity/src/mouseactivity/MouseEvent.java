package mouseactivity;

import java.util.EventObject;

public class MouseEvent extends EventObject {
	private static final long serialVersionUID = -8194688548489965445L;
	
	public static final int TRANSITION_STATE_MOVE = 1,TRANSITION_STATE_DOWN = 2,TRANSITION_STATE_UP = 3;
	public static final int BUTTON_NO = 0x0,BUTTON_LEFT = 1<<1,BUTTON_RIGHT = 1<<2;
	
	protected GlobalMouseListener listener;
	protected int transitionState,button,buttons;
	protected int x,y;

	public MouseEvent(Object source,GlobalMouseListener listener,int transitionState,int button,int buttons,int x,int y) {
		super(source);
		this.listener = listener;
		this.transitionState = transitionState;
		this.button = button;
		this.buttons = buttons;
		this.x = x;
		this.y = y;
	}
	
	public int getTransitionState() { return transitionState; }
	public int getButton() { return button; }
	public int getButtons() { return buttons; }
	public int getX() { return x; }
	public int getY() { return y; }
	
	public boolean equals(MouseEvent event) {
		return event.getButton()==button
		     &&event.getButtons()==buttons
		     &&event.getX()==x
		     &&event.getY()==y;
	}
	
	@Override public String toString() {
		StringBuilder string = new StringBuilder().append(x).append(',').append(y);
		if(buttons!=BUTTON_NO) {
			string.append(" [");
			if((buttons&BUTTON_LEFT)!=BUTTON_NO)
				string.append("left,");
			if((buttons&BUTTON_RIGHT)!=BUTTON_NO)
				string.append("right,");
			return string.deleteCharAt(string.length()-1).append(']').toString();
		} else return string.toString();
	}
}
