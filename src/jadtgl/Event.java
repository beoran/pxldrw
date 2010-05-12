package jadtgl;

/** 
 * Events which the platform may send to the widgets. It's simplified so one event 
 * size "fits all" so to speak. 
 */
public interface Event {
    enum Kind {
        MOUSE_UP        , MOUSE_DOWN 	, MOUSE_CLICK  , MOUSE_MOVE  , MOUSE_DRAG,
	MOUSE_IN	, MOUSE_OUT  	, MOUSE_WHEEL  ,
	KEY_PRESS   	, KEY_RELEASE	, KEY_TYPE     , 
	WIDGET_CLOSE	, WIDGET_QUIT	, WIDGET_RESIZE, WIDGET_MOVE,
	JOYSTICK_AXIS	, JOYSTICK_DOWN	, JOYSTICK_UP  , UNKNOWN
    } ;		
        
    /** The kind of event. */
    Event.Kind kind();
	
    /** Returns a Event.Mouse if this is a mouse event, or null if not. */
    Event.Mouse 	mouse();
    /** Returns a Event.Key if this is a keyboard event, or null if not. */
    Event.Key 		key();
    /** Returns a Event.Widget if this is a widget event, or null if not. */
    Event.Widget 	widget();
    /** Returns a Event.Joystick if this is a joystick event, or null if not. */
    Event.Joystick 	joystick();
		
	
    /**Details for mouse events. Not valid for other events. */
    interface Mouse extends Event {
	/** x location of the mouse  when the event happened. */
	int 	x();
	/** y location of the mouse  when the event happened. */
	int 	y();
	/** width of drag motion if available. */
	int 	w();
	/** height of drag motion if available. */
	int 	h();
	/** Buttons that changed state. */
	int 	buttons();
	/** Returns the rotation of the mouse wheel if wheel(- is true.*/
	int 	rotation();
	/** Returns true if this is a mouse drag event. */
	boolean drag();
	/** Returns true if this is a mouse button down  event. */
	boolean down();
	/** Returns true if this is a mouse button up event. */
	boolean up();
	/** Returns true if this is a mouse click event. */
	boolean click();
	/** Returns true if this is a mouse wheel event. */
	boolean wheel();
	/** Returns true if this is a mouse "in" even, that s, the mouse entered the window or component. */
	boolean in();
	/** Returns true if this is a mouse "out" even, that s, the mouse left the window or component. */
    	boolean out();
    }
	
	/** Possible virtual key symbols */
    enum Sym {
    	NONE, K_0, K_1, K2, K3, K_4, K_5, K_6, K_7, K_8, K_9,
    }
    
    /** Allowed key modifier. */
    enum Mod {
        NONE(0), SHIFT(1), CTRL(2), ALT(4), ALTGR(8), SUPER(16), MENU(32);

        int _value;
        Mod(int value) {
                _value = value;
        }
    }
    
    /** Details for keyboard events. Will be not valid for other events. */
    interface Key extends Event {
        /** Text that this key represents. Only valid if type() is true. */
        char	text();
        /** Key symbol of this event. */
        Sym 	sym();
        /** Key modifyers. */
        Mod 	mod();
        /** Returns true if this is a key press event. */
        boolean press();
        /** Returns true if this is a key release event. */
        boolean release();
        /** Returns true if this is a key typed event. */
        boolean type();
        /** Returns true if this is a key repetition event. */
        boolean repeat();
    }

    /* Widget or window events. */
    interface Widget extends Event {
        /** Set to true if the widget or window is closing. */
        boolean close();
        /** Set to true if the widget or window has been destroyed. */
        boolean quit();
        /** Returns true if the widget or window has been resized. */
        boolean resize();
        /** Returns true if the widget or window has been moved. */
        boolean move();
        /** New x position of widget. If negative, means "unknown". */
        int x();
        /** New y position of widget. If negative, means "unknown". */
        int y();
        /** New width of widget. If negative, means "unknown". */
        int w();
        /** New height of widget. If negative, means "unknown". */
        int h();
    }

    /** Joystick events. */
    interface Joystick extends Event {
        int stick();
        int axis();
        int value();
        int buttons();
        boolean down();
        boolean up();
        boolean move();
    }
	
}


