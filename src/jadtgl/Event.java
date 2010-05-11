package jadtgl;

/** Events which the platform may send to the widgets. It's simplified so one event 
 * size "fits all" so to speak. */
public interface Event {
	enum Kind { MOUSE_UP , MOUSE_DOWN , MOUSE_CLICK, MOUSE_DRAG,
				KEY_PRESS, KEY_RELEASE, KEY_TYPE   , QUIT     , 
				FINISH   ,  
    } ;		
	/* The kind of event. */
	Event.Kind kind();		
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