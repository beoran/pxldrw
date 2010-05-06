/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Simple wrapper around JFrame.
 * @author bjmey
 */
public class Frame extends JFrame {
    public Frame(String name, int w, int h) {
        super(name);
        this.setSize(w, h);
    }

    public void addChild(JComponent child) {
        this.getContentPane().add(child);
    }

}

