/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrj;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author bjmey
 */
public class Frame extends JFrame {
    Frame(String name, int w, int h) {
        super(name);
        this.setSize(w, h);
    }

    void addChild(JComponent child) {
        this.getContentPane().add(child);
    }

}
