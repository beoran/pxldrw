package pxldrw.logic;

/**
 * A Palette is a collection of Colors accessible by their numerical index.
 * @author bjmey
 */
public class Palette {
    java.util.Vector<Color> colors;

    public Palette() {
        colors = new java.util.Vector<Color>();
    }

    public static Palette make() {
        return new Palette();
    }

    /** Returns the size of the palette */
    public int size() {
        return colors.size();
    }

    /** Adds a color to the palette. */
    public Color add(Color color) {
        colors.add(color);
        return color;
    }

    /** Adds an RBG color to the palette. */
    public Color add(int r, int g, int b) {
        return this.add(RGBColor.make(r, g, b));
    }

    /** Adds the clear color the palette. */
    public Color add() {
        return this.add(Clear.make());
    }

    /** Returns true if a color exists at the index, false if not. */
    public boolean exist(int index) {
        if (index < 0)              return false;
        if (index >= this.size())   return false;
        return true;
    }

    /** Returns the color at the given index or null if it does not exist. */
    public Color get(int index) {
       if (!this.exist(index)) return null;
       return colors.get(index);
    }

}
