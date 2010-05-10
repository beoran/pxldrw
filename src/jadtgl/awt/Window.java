package jadtgl.awt;



import jadtgl.Widget;
import jadtgl.Platform.Color;
import jadtgl.Platform.Font;
import jadtgl.Platform.Graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import static java.awt.AWTEvent.*;
import static pxldrw.tools.Puts.*;


public class Window extends java.awt.Frame 
implements jadtgl.Platform.Window {
		
		private static final long serialVersionUID = 635859928665977908L;
		
		
		static final long ALL_EVENTS = ACTION_EVENT_MASK + ADJUSTMENT_EVENT_MASK 
		+ AWTEvent.COMPONENT_EVENT_MASK + AWTEvent.CONTAINER_EVENT_MASK 
		+ AWTEvent.FOCUS_EVENT_MASK + AWTEvent.HIERARCHY_BOUNDS_EVENT_MASK 
		+ AWTEvent.INPUT_METHOD_EVENT_MASK + AWTEvent.INVOCATION_EVENT_MASK 
		+ AWTEvent.ITEM_EVENT_MASK + AWTEvent.KEY_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK 
		+ AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_WHEEL_EVENT_MASK 
		+ AWTEvent.PAINT_EVENT_MASK + AWTEvent.TEXT_EVENT_MASK + AWTEvent.WINDOW_EVENT_MASK
		+ AWTEvent.WINDOW_FOCUS_EVENT_MASK + AWTEvent.WINDOW_STATE_EVENT_MASK;
		 
		/** The root level widget. */
		Widget widget;
		/** Canvas for rendering on. */
		java.awt.Canvas	canvas;
		/** Double buffer to reduce flicker. */
		BufferStrategy 	buffer;
		
		public Window(String title, int w, int h) {
			super("Hi!");
			this.enableEvents(ALL_EVENTS);			 
			this.setVisible(true);
			this.setSize(w, h);
			this.setIgnoreRepaint(true);
			// Create canvas for painting the widgets on.
			canvas = new Canvas();
			canvas.setIgnoreRepaint( true );
			canvas.setSize(w, h);
			// Add canvas to the window...
			this.add(canvas);
			this.pack();
			// Create BackBuffer...
			canvas.createBufferStrategy( 2 );
			buffer = canvas.getBufferStrategy();
			puts("buffer", buffer);
			this.draw();		 
		}
		 
		@Override 
		public void processEvent(java.awt.AWTEvent e) {
			// can only send events if there is a root widget.
			if (widget == null) {
				if( e.getID() == WindowEvent.WINDOW_CLOSING) {
					this.dispose();							
				}
				return;
			}
		}
		
		public jadtgl.Platform.Window draw() {	
			if(buffer == null) return this; 
			if(!this.isDisplayable()) return this;
			if (widget == null) return this;
			Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
			puts("Draw", g);
			Graphics graphics = this.graphics(); 
			widget.drawAll(graphics);
			buffer.show();
			puts("Draw OK");
			g.dispose();
			return this;
		}


	
	@Override
	public boolean active() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Color color(int r, int g, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color color(int r, int g, int b, int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font defaultfont(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font font(String fontname, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] fontnames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graphics graphics() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public jadtgl.Platform.Window update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget widget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget widget(Widget widget) {
		// TODO Auto-generated method stub
		return null;
	}

}
