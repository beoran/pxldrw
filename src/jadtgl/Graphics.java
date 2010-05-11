package jadtgl;


/** Platform independent drawing operations. */
public interface Graphics { 	
	/** 
	 * Sets the color that will be used for all following drawing operations. 
	 * Typical use would be graphics.color(col).line(x, y, w, h); 
	 **/
	Graphics color(Paint color);
	Graphics color(int r, int g, int b);
	Graphics color(int r, int g, int b, int a);	
	/** 
	 * Sets the font that will be used for all following text drawing operations. 
	 * Typical use would be graphics.font(myfont).text(x, y, "hello"); 
	 **/
	Graphics font(Font font);
	
	/** Draws a line starting at x,y, and fitting inside a rectangle with ieght h and width w */
	Graphics line(int x, int y, int w, int h);

	/** Draws an open rectangle outline. */ 
	Graphics rectangle(int x, int y, int w, int h);

	/** Draws the outline of an oval. */	
	Graphics oval(int x, int y, int w, int h);

	/** Draws a slab, which is a filled rectangle */
	Graphics slab(int x, int y, int w, int h);
	
	/** Draws a disk, that is, a filled oval. */ 
	Graphics disk(int x, int y, int w, int h);
	
	/** Draws the given image at the given coordinates x, y */
	Graphics blit(int x, int y, Image image);
	
	/** Draws the given image, stretched to the given coordinates */
	Graphics stretch(int x, int y, int w, int h, Image image);
	
	/** Draws the given utf8 encoded text at the given coordinates using the 
	 * given font and foreground paint.
	 */	
	Graphics text(int x, int y, String utf8);
}