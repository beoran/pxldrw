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

    public Grid grid;
    public int wide, high;
    public int zoom;

    public Gridedit(Grid grid) {
        super();
        this.addMouseMotionListener(this);
        this.grid = grid;
        this.zoom = 10;
        this.wide = grid.wide() * this.zoom;
        this.high = grid.high() * this.zoom;
        Dimension dim  = new Dimension(wide, high);
        this.setMinimumSize(dim);
        this.setSize(wide, high);
        this.setMaximumSize(dim);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int x, y, i, j;
        printf("Painting! %d %d\n", grid.high(), grid.wide());
        for (i = 0 ; i < grid.high() ; i ++) {
            y = i * zoom;
            for (j = 0 ; j < grid.wide() ; j++) {
                x = j * zoom;
                pxldrw.logic.Color gc = grid.get(j, i);
                if (gc == null) continue;
                java.awt.Color col = gc.awt();
                if (col == null) continue;
                g2.setPaint(col);
                g2.fillRect(x, y, zoom, zoom);
            }
        }

    }

    public void mouseDragged(MouseEvent e) {
        printf("%s", grid.set(e.getX() / zoom, e.getY() / zoom, 1).toString());
        printf("Set! %d %d: %d -> %d", e.getX(), e.getY(), 1, 0);
        this.repaint();
    }

    public void mouseMoved(MouseEvent e) {

    }




}

