package jadtgl;

public interface Widget extends Handler {
	/** Redraws the widget and it's children using the given graphics context. */
	void 			drawAll(Platform.Graphics graphics);
	/** Sets this widget's back end window. */
	Platform.Window	setWindow(Platform.Window window);
	/** Returns this widget's back end window. */
	Platform.Window window();	
	/** This widget's root widget */
	Widget			root();	
}
