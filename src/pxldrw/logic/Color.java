
package pxldrw.logic;

/**
 * A color is any object that can be used to specify colors.
 * @author bjmey
 */
public interface Color {
    /** Returns true if the color is the transparent color, false if not. */
    boolean transparent();
    /** Returns true if the color is not the transparent color, false if it is. */
    boolean opaque();
    /** Transforms color to an AWT color for display.  */
    java.awt.Color awt();
    /** Transforms color to an AWT color for display. May be grayscaled if grayscale is true. */
    java.awt.Color awt(boolean grayscale);
    int G();
    int B();
	int R();
}
