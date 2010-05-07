/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.gui;

import javax.swing.*;

/**
 * A subframe is a framet hat can only exist if it's added to the Root window.
 * It's ac hild of JInternalFrame
 * @author bjmey
 */
public class Subframe extends JInternalFrame {
    public Subframe(String name, int w, int h) {
        super(name);
        this.setSize(w, h);
    }

    public void addChild(JComponent child) {
        this.getContentPane().add(child);
    }
}
