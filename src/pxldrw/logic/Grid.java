/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.logic;

/**
 * A grid is the most fundamental part of pixel art. It's a 2 dimensional
 * raster in which pixels of a given color are placed. It's linked to a palette
 * in which the actual values of the colors are looked up.
 * @author bjmey
 */
public class Grid {
    protected int[][] grid;
    protected int wide, high;
    protected Palette palette;

    public Grid(int wide, int high, Palette palette) {
        this.palette = palette;
        this.wide    = wide;
        this.high    = high;
        this.grid    = new int[high][wide];
    }

    /** Returns the width of the grid. */
    public int wide() {
        return this.wide;
    }

    /** Returns the height of the grid. */
    public int high() {
        return this.high;
    }

    /** Returns true if it's possible to get the pixel at the given xoordinates, and false if not*/
    public boolean exist(int x, int y) {
        if (x < 0 || y < 0)  return false;
        if (x >= wide()) return false;
        if (y >= high()) return false;
        return true;
    }

    /** Looks up the Color of the color index in this grid's palette */
    public Color lookup(int index) {
        return palette.get(index);
    }

    /** Puts the indexed color at the given location and returns it's Color.
     * Will do nothibg and return null in case the pixel is out of bounds or
     * the index is not in the palette.
     */
    public Color set(int x, int y, int index) {
        if(!exist(x, y)) return null;
        return this.palette.get(index);
    }

    /**
     * Gets the index of color at the given coordinates.
     * Will raise a bounds error if out of bounds
     */
    protected int getIndex(int x, int y) {
        return this.grid[y][x];
    }

    /**
     * Gets the Color at the given coordinates. Returns null if no such color.
     */
    public Color get(int x, int y) {
        if(!exist(x, y)) return null;
        return this.palette.get(getIndex(x, y));
    }

    /**
     * Fills the grid with a single index.
     */
    public void fill(int index) {
        int x, y;
        for (y = 0 ; y < high; y++ ) {
            for (x = 0 ; x < wide; x++ ) {
                this.set(x, y, index);
            }
        }
    }








}
