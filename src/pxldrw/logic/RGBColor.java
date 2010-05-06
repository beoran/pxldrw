/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.logic;

/**
 * A Color that uses the 0..255 color space.
 * RGG Color is immutable.
 @author bjmey
 */
public class RGBColor implements Color {
    protected int r, g , b, gray;
    protected java.awt.Color awt, awtgray;

    public RGBColor(int r, int g, int b) {
        this.r      = r;
        this.g      = g;
        this.b      = b;
        this.gray   = (r + g + b) / (255 * 3);
        this.awt    = new java.awt.Color(this.r, this.g, this.b);
        this.awtgray= new java.awt.Color(this.gray, this.gray, this.gray);
    }

    public static Color make(int r, int g, int b) {
        return new RGBColor(r,g,b);
    }

    public boolean transparent() {
        return false;
    }

    public boolean opaque() {
        return true;
    }

    public java.awt.Color awt() {
        return awt;
    }

    public java.awt.Color awt(boolean grayscale) {
        return awtgray;
    }
    
    @Override
    public String toString() {
        return String.format("RGBColor: %d %d %d (AWT: %s)", r, g, b, awt.toString());
    }

}
