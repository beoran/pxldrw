package jadtgl;


/** Display is generic GUI system or layer of the platform. */
public interface Display {
	/** Generates a window with the given title and size. */
	Window window(String title, int w, int h);
	
	/** Returns the first window that is still active. May return nil if no such window exists. */
	Window defaultwindow();		

	/** Loads a font with the given name and returns it. */
	Font  font(String fontname, int size);

	/** Returns all valid font names in an array of names. */
	String[] fontnames();

	/** Returns the platform default font, loaded with the given size. */		
	Font defaultfont(int size);
	
	/** Loads an image with the given name, or from the given resource. */
	Image  image(String name);		
}