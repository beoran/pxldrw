/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrj;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
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
        this.wide = grid.wide * this.zoom;
        this.high = grid.high * this.zoom;
        Dimension dim  = new Dimension(wide, high);
        this.setMinimumSize(dim);
        this.setSize(wide, high);
        this.setMaximumSize(dim);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int x, y, i, j;
        // System.out.printf("Painting! %d %d\n", grid.high, grid.wide);
        for (i = 0 ; i < grid.high ; i ++) {
            y = i * zoom;
            for (j = 0 ; j < grid.wide ; j++) {
                x = j * zoom;
                Grid.Color gc = grid.get(j, i);               
                if (gc == null) continue;
                Color color = new Color(gc.r, gc.b, gc.g);
                g2.setPaint(color);
                g2.fillRect(x, y, zoom, zoom);
            }
        }

    }

    public void mouseDragged(MouseEvent e) {
        grid.setRGB(e.getX() / zoom, e.getY() / zoom, 255, 255, 255);
        this.repaint();
    }

    public void mouseMoved(MouseEvent e) {

    }




}
