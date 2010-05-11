package jadtgl;

/** Models a platform independent font
 * 
 */
public interface Font {
	/** Returns the name of the font. */
	String name(); 		
	/** Returns the point size of the font */
	int size();
	/** Returns the default spacing distance between lines of text */
	int space();
	/** Returns the actual width that the text utf8 would have when rendered. */
	int width(String utf8);
	/** Returns the actual height that the text utf8 would have when rendered. */
	int height(String utf8);		
}