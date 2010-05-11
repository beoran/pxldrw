package jadtgl;

public interface Handler {
	interface Reply {} ; 
	enum Status implements Reply { OK, PASS, CANCEL, QUIT }; 
	
	/** Called when the mouse button is pressed. */
	Reply onMouseDown(int x , int y, int buttons);
	/** Called when the mouse button is released. */
	Reply onMouseUp(int x   , int y, int buttons);
	/** Called when the mouse button is clicked. */
	Reply onMouseClick(int x, int y, int buttons);
	/** Called when the mouse is dragged. */
	Reply onMouseDrag(int x , int y, int buttons);
	
	/** Called when the mouse enters the area of the object. */
	Reply onMouseEnter(int x, int y, int button);
	/** Called when the mouse leave the area of the object. */
	Reply onMouseLeave(int x, int y, int button);
	/** Called when the mouse moves. */
	Reply onMouseMove(int x, int y, int button);
	/** Called when the mouse wheel is turned. */
	Reply onMouseWheel(int x, int y, int button, int by);
	
	/** Called when a key on the keyboard is pressed. */
	Reply onKeyDown(char text, int keycode);
	/** Called when a key on the keyboard is released. */
	Reply onKeyUp(char text, int keycode);
	/** Called when a key on the keyboard is typed. */
	Reply onKeyType(char text, int keycode);
	
	/** Called when the application requests to close the window. 
	 * Reply with CANCEL to stop this from happening. 
	 **/
	Reply onWindowClose();	
	/** Called when the application is quitting. This cannot be stopped anymore.*/
	Reply onWindowQuit();
}
