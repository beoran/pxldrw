package jadtgl;

/** 
 * An interface that models the specifics of a platform back-end
*/ 
public interface Platform {
	
	// Models a paint that can be used with the Platform's graphics.
	public interface Paint {
		
	}
	
	/** Models a generic color independent from platform-specific colors.
	 */
	public interface Color extends Paint {
		int r();
		int g();
		int b();
		int a();
		boolean transparent();
		boolean opaque();
	}
	
	/** Models a platform independent font
	 * 
	 */
	public interface Font {
		/** Returns the name of the font. */
		String name(); 		
		/** Returns the point size of the font */
		int size();
		/** Returns the default spacing distance between lines of text */
		int space();
		/** Returns the actual width that the text utf8 would have when rendered. */
		int width(String utf8);
		/** Returns the actual height that the text utf8 would have when rendered. */
		int height(String utf8);		
	}
	
	
	/** Models a platform-independent image.
	 */
	public interface Image {		
		/** Returns the height of the image. */
		int width();
		int height();
		/** Returns a graphics context that can be used to draw on this image. 
		 *  May return nil if this is not possible;
		 */
		Platform.Graphics graphics();
		/** Returns an image that has been stretched from this one.  */
		Image stretch(int w, int h);
		/** Returns an image that has been resized from this one.  */
		Image resize(int w, int h);
	}
	
	/** Events which the platform may send to the widgets. It's simplified so one event 
	 * size "fits all" so to speak. */
	public interface Event {
		enum Kind { MOUSE_UP , MOUSE_DOWN , MOUSE_CLICK, MOUSE_DRAG,
					KEY_PRESS, KEY_RELEASE, KEY_TYPE   , QUIT     , 
					FINISH   ,  
			} ;		
		/* The kind of event. */
		Kind kind();		
		/**Details for mouse events. Not valid for other events. */
		boolean mouse();
		int 	x();
		int 	y();
		int 	w();
		int 	h();
		int 	buttons();
		boolean drag();
		boolean down();
		boolean up();
		boolean click();
		/** Details for keyboard events. Will be not valid for other events. */
		boolean keyboard();
		String 	text();
		int 	key();
		boolean press();
		boolean release();
		boolean type();
		boolean repeat();
		/* System events. */
		boolean quit();
		boolean finish();
		/* Suppress passing on this event to other widgets. */
		Event 	eat();
		/** Was this event suppressed? */
		boolean eaten();
	} 
	
	/** Platform independent drawing operations. */
	interface Graphics { 	
		/** Draws a line starting at x,y, and fitting inside a rectangle with ieght h and width w */
		Graphics line(int x, int y, int w, int h);
	
		/** Draws an open rectangle outline. */ 
		Graphics rectangle(int x, int y, int w, int h, Paint color);
	
		/** Draws the outline of a circle. */	
		Graphics circle(int x, int y, int w, int h, Paint color);
	
		/** Draws a box, which is a filled rectangle */
		Graphics box(int x, int y, int w, int h, Paint color);
		
		/** Draws a disk, that is , a filled circle. */ 
		Graphics disk(int x, int y, int w, int h, Paint color);
		
		/** Draws the given image at the given coordinates x, y */
		Graphics blit(int x, int y, Image image);
		
		/** Draws the given image, stretched to the given coordinates */
		Graphics stretch(int x, int y, int w, int h, Image image);
		
		/** Draws the given utf8 encoded text at the given coordinates using the 
		 * given font and foreground paint.
		 */	
		Graphics text(int x, int y, Font font, Paint color, String utf8);
	}
	
	/** A window is a platform dependent back-end window on which a GUI an be displayed. */
	interface Window {
		/** Returns a graphics context that can be used to draw on this window. 
		 *  May return nil if this is not possible;
		 */		
		Graphics graphics();
		/** Returns a color that can be used with this window's Graphics */
		Color color(int r, int g, int b);
		/** Returns a color that can be used with this window's Graphics */
		Color color(int r, int g, int b, int a);
		/** Loads a font with the given name and returns it. */
		Font  font(String fontname, int size);
		/** Returns all valid font names in an array of names. */
		String[] fontnames();
		/** Returns the platform default font, loaded with the given size. */		
		Font defaultfont(int size);				
		/** Gets the active root widget of the platform window, or nil if not yet set. */
		Widget widget();		
		/** Sets the active root widget of the platform window, and returns it. */
		Widget widget(Widget widget);		
		/** Draws the window. */
		Window draw();		
		/** Causes the window to process it's events if this doesn't happen automatically. */
		Window update();				
		/** Returns true if the window is active, false if not (ie, it can't be used anymore). */
		boolean active();		
	}
	
	/** System is generic GUI system or layer of the platform. */
	interface System {
		/** Generates a window with the given title and size. */
		Window window(String title, int w, int h);
		
	}
	
	
}
