package jadtgl.awt;



import jadtgl.Color;
import jadtgl.Graphics;
import jadtgl.Handler;
import jadtgl.Widget;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import static java.awt.AWTEvent.*;
import static pxldrw.tools.Puts.*;


public class Window extends java.awt.Frame 
implements jadtgl.Window {
		
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
		/** Graphics wrapper. We don't use double buffering as that is too slow. */
		Graphics graphics;
		
		
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
			graphics = new jadtgl.awt.Graphics(canvas.getGraphics());
			this.draw();		 
		}
		 
		@Override 
		public void processEvent(java.awt.AWTEvent e) {
			// can only send events if there is a root widget.
			if (widget == null) {
				// if no root widget, ensure that quit still works.
				if( e.getID() == WindowEvent.WINDOW_CLOSING) {
					this.dispose();							
				}
				puts("unhandled event: no widget: ", e);
				return;
			}
			
			jadtgl.Handler.Reply reply 	= null;
			MouseEvent 			me 		= null;
		    MouseWheelEvent		mw 		= null;
		    WindowEvent			we 		= null;				 
			KeyEvent   			ke 		= null;
			ComponentEvent		ce		= null;
			
			switch (e.getID()) {
			case MouseEvent.MOUSE_PRESSED:
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseDown(me.getX(), me.getY(), me.getButton());
			break;
			case MouseEvent.MOUSE_RELEASED:
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseUp(me.getX(), me.getY(), me.getButton());
			break;	
			case MouseEvent.MOUSE_CLICKED:
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseClick(me.getX(), me.getY(), me.getButton());
			break;
			case MouseEvent.MOUSE_DRAGGED:
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseDrag(me.getX(), me.getY(), me.getButton());
			break;			
			case MouseEvent.MOUSE_ENTERED: 	
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseEnter(me.getX(), me.getY(), me.getButton());
			break;
			case MouseEvent.MOUSE_EXITED: 	
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseLeave(me.getX(), me.getY(), me.getButton());
			break;
			case MouseEvent.MOUSE_MOVED: 	
				me 		= (MouseEvent) e;
				reply 	= widget.onMouseMove(me.getX(), me.getY(), me.getButton());
			break;
			case MouseWheelEvent.MOUSE_WHEEL:	
				mw 		= (MouseWheelEvent) e;
				reply 	= widget.onMouseWheel(mw.getX(), mw.getY(), mw.getButton(), mw.getWheelRotation());
			break;
			case KeyEvent.KEY_PRESSED: 	
				ke 		= (KeyEvent) e;
				reply 	= widget.onKeyDown(ke.getKeyChar(), ke.getKeyCode());
			break;
			case WindowEvent.WINDOW_CLOSING:
				we 		= (WindowEvent) e;
				reply	= widget.onWindowClose();
			break;
			case WindowEvent.WINDOW_CLOSED:
				we 		= (WindowEvent) e;				
				reply	= widget.onWindowQuit();
			break;
			case ComponentEvent.COMPONENT_RESIZED:
				ce 		= (ComponentEvent) e;				
	//			reply	= widget.onWindowResize();				
			default:
				puts("unhandled event", e);
			break;			
			}
			
			if (reply != null && reply == Handler.Status.QUIT) {
				this.dispose();
			}
		}
		
		public jadtgl.Window draw() {	
			if(!this.isDisplayable()) return this;
			if (widget == null) return this;			
			Graphics graphics = this.graphics();
			widget.drawAll(graphics);
			return this;
		}


	
	@Override
	public boolean active() {
		return this.isDisplayable();
	}

	@Override
	public Color color(int r, int g, int b) {
		return new jadtgl.awt.Color(r, g, b, 255);
	}

	@Override
	public Color color(int r, int g, int b, int a) { 
		return new jadtgl.awt.Color(r, g, b, a);
	}

	@Override
	public Graphics graphics() {		
		return graphics;
	}


	@Override
	public jadtgl.Window update() {
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
