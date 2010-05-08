/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.gui;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import pxldrw.logic.*;
import static pxldrw.tools.Puts.*;

/**
 * Gridedit is a simple editor fro a Grid which is a piece of pixel art.
 * @author bjmey
 */
public class Gridedit extends JComponent
implements MouseMotionListener
{
    public static final int ZOOM_MAX = 20;

    public Grid grid;
    public int wide, high;
    public int zoom;

    public Gridedit(Grid grid, int zoom) {
        super();
        this.setOpaque(false);
        this.addMouseMotionListener(this);
        this.grid = grid;
        this.zoom = zoom;
        this.sizeChanged();
    }

    public Gridedit(Grid grid) {
        this(grid, 10);
    }

    /* Call this whenever the size of the grid editor should be changed. */
    public void sizeChanged() {
        this.wide = grid.wide() * this.zoom;
        this.high = grid.high() * this.zoom;
        Dimension dim  = new Dimension(wide, high);
        this.setMinimumSize(dim);
        this.setSize(wide, high);
        this.setMaximumSize(dim);
        this.setPreferredSize(dim);
    }

    /** Sets the current zoom factor of the grid editor. */
    public int zoom(int z) {
        if (z < 1 || z > ZOOM_MAX ) return this.zoom;
        this.zoom = z;
        this.sizeChanged();
        this.repaint();
        return this.zoom;
    }

    /** Returns the current zoom factor of the grid editor. */
    public int zoom() {
        return this.zoom;
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2    = (Graphics2D) g;
        Rectangle bounds = g.getClipBounds();
        int x, y, gy, gx;
        // printf("Painting! %d %d\n", grid.high(), grid.wide());
        for (gy = 0 ; gy < grid.high() ; gy ++) {
            y = gy * zoom;
            for (gx = 0 ; gx < grid.wide() ; gx++) {
                x = gx * zoom;
                Rectangle drawrect = new Rectangle(x, y, zoom, zoom);
                if (!bounds.intersects(drawrect)) {
                    continue;
                }

                pxldrw.logic.Color gc = grid.get(gx, gy);
                if (gc == null) { continue; }
                java.awt.Color col = gc.awt();
                if (col == null) { continue; }
                g2.setPaint(col);
                g2.fill(drawrect);
            }
        }

    }

    public void mouseDragged(MouseEvent e) {
        int gridx, gridy;
        gridx = e.getX() / zoom;
        gridy = e.getY() / zoom;
        grid.set(gridx, gridy, 1);
        this.repaint();
    }

    public void mouseMoved(MouseEvent e) {

    }




}

