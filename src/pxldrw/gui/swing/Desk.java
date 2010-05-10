/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.gui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Desk is the desktop pane that contains the Subframes of the pxldrw application.
 * @author bjmey
 */
public class Desk extends JDesktopPane {
    
    /** This is the desktop manager that the Desk window uses. */
    public static class Manager extends DefaultDesktopManager   {

        public static DesktopManager make() {
            return new Manager();
        }

        @Override
        public void dragFrame(JComponent f, int x, int y) {
            if (x < 0) x = 0;
            if (y < 0) y = 0;


            super.dragFrame(f, x, y);
        }

        @Override
        public void resizeFrame(JComponent f, int newX, int newY, int newWidth, int newHeight) {
            super.resizeFrame(f, newX, newY, newWidth, newHeight);
        }


    }

    public Desk() {
        super();
        this.setSize(640, 480);
        //this.setDesktopManager(Manager.make());
        this.setForeground(Color.white);
        this.setBackground(Color.black);
    }

    public void addChild(JComponent child) {
        this.add(child);
    }

}
