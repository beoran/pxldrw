package jadtgl;

/** A window is a platform dependent back-end window on which a GUI an be displayed. */
public interface Window {
	/** Returns a graphics context that can be used to draw on this window. 
	 *  May return nil if this is not possible;
	 */		
	Graphics graphics();
	/** Returns a color that can be used with this window's Graphics */
	Color color(int r, int g, int b);
	/** Returns a color that can be used with this window's Graphics */
	Color color(int r, int g, int b, int a);
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