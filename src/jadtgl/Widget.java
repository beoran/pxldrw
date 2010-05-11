package jadtgl;


public interface Widget extends Handler {
	/** Redraws the widget and it's children using the given graphics context. */
	void 			drawAll(Graphics graphics);
	/** Sets this widget's back end window. */
	Window	window(Window window);
	/** Returns this widget's back end window. */
	Window window();	
	/** This widget's root widget */
	Widget			root();
	
	
	
}
