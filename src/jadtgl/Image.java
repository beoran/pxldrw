package jadtgl;

/** Models a platform-independent image.
 */
public interface Image {		
	/** Returns the height of the image. */
	int width();
	int height();
	/** Returns a graphics context that can be used to draw on this image. 
	 *  May return nil if this is not possible;
	 */
	Graphics graphics();
	/** Returns an image that has been stretched from this one.  */
	Image stretch(int w, int h);
	/** Returns an image that has been resized from this one.  */
	Image resize(int w, int h);
}