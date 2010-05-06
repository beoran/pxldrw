/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrj;

/**
 *
 * @author bjmey
 */
public class Grid {
    public static class Color {
        public int r, g, b, a;
        public Color(int r, int g, int b, int a) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }
    }

    public static Grid.Color color(int r, int g, int b, int a) {
           return new Grid.Color(r, g, b, a);
    }

    public static Grid.Color color(int r, int g, int b) {
           return color(r, g, b, 255);
    }

    public int wide, high;

    protected Color[][] grid;

    public Grid(int wide, int high) {
        grid = new Color[high][wide];
        this.wide = wide;
        this.high = high;
    }

    protected boolean outOfBounds(int x, int y) {
        if (x < 0)          return true;
        if (y < 0)          return true;
        if (x >= this.wide) return true;
        if (y >= this.high) return true;
        return false;
    }

    public Color get(int x, int y)  {
        if (this.outOfBounds(x, y)) return null;
        return grid[y][x];
    }

    public Color set(int x, int y, Color color) {
        if (this.outOfBounds(x, y)) return null;
        return grid[y][x] = color;
    }

    public Color setRGB(int x, int y, int r, int g, int b) {
        return this.set(x, y, color(r, g, b));
    }

    public void fill(Color color) {
        int x, y;
        for (y = 0 ; y < high; y++ ) {
            for (x = 0 ; x < wide; x++ ) {
                this.set(x, y, color);
            }
        }
    }



}
