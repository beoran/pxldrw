package jadtgl;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import static java.awt.AWTEvent.*;
import static pxldrw.tools.Puts.*;

public class Pane extends Frame {
	
	private static final long serialVersionUID = 635859928665977908L;
	
	java.awt.Frame handle;
	Canvas 		canvas;
	BufferStrategy buffer;
	static final long ALL_EVENTS = ACTION_EVENT_MASK + ADJUSTMENT_EVENT_MASK 
	+ AWTEvent.COMPONENT_EVENT_MASK + AWTEvent.CONTAINER_EVENT_MASK 
	+ AWTEvent.FOCUS_EVENT_MASK + AWTEvent.HIERARCHY_BOUNDS_EVENT_MASK 
	+ AWTEvent.INPUT_METHOD_EVENT_MASK + AWTEvent.INVOCATION_EVENT_MASK 
	+ AWTEvent.ITEM_EVENT_MASK + AWTEvent.KEY_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK 
	+ AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_WHEEL_EVENT_MASK 
	+ AWTEvent.PAINT_EVENT_MASK + AWTEvent.TEXT_EVENT_MASK + AWTEvent.WINDOW_EVENT_MASK
	+ AWTEvent.WINDOW_FOCUS_EVENT_MASK + AWTEvent.WINDOW_STATE_EVENT_MASK;
	 
	 public Pane() {
		 super("Hi!");
		 this.enableEvents(ALL_EVENTS);
		 
		 this.setVisible(true);
		 this.setSize(640, 480);
		 this.setIgnoreRepaint(true);
		 // handle.addWindowListener(this);
		 // handle.  setDefaultCloseOperation(0);

		 // Create canvas for painting...
		 canvas = new Canvas();
		 canvas.setIgnoreRepaint( true );
		 canvas.setSize( 640, 480 );
		 		
		 // Add canvas to game window...
		 this.add( canvas );
		 this.pack();
		 // Create BackBuffer...
		 canvas.createBufferStrategy( 2 );
		 buffer = canvas.getBufferStrategy();
		 puts("buffer", buffer);
		 this.draw();		 
	}
	 
	@Override 
	public void processEvent(java.awt.AWTEvent e) {		
		// puts("AWT event: ", e);
		if( e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();			
		} else {
			this.draw();
		}
	}
	
	public void draw() {	
		if(buffer == null) return; 
		if(!this.isDisplayable()) return;
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		puts("Draw", g);
		g.setColor(new Color(127,127,0));
		g.fillRect(0, 0, 640, 480);
		buffer.show();
		puts("Draw OK");
		g.dispose();
	}

		 

}
