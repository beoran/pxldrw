package jadtgl;

/** Models the display of a user interface. 
 * Has static methods to generate the platform dependent 
 * display 
 **/
public class Jadtgl {
	public static final String PLATFORM = "awt";
	static jadtgl.awt.Display _display  = null; 
	
	/** Returns the display for this platform. Works a bit like a singleton. */
	public static Display display() {
		if( PLATFORM.equals("awt") ) {
			if (_display == null) {
				_display = new jadtgl.awt.Display();
			}	
			return _display; 
		} else {
			return null;
		}		
	}
	
}
