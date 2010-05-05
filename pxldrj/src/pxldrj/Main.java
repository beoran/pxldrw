/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrj;

import javax.swing.JFrame;

/**
 *
 * @author bjmey
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame         = new Frame("pxldrwj", 300, 300);
        Grid grid           = new Grid(64, 64);
        Gridedit gridedit   = new Gridedit(grid);
        grid.fill(Grid.color(0,0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.BorderLayout());
        frame.addChild(gridedit);
        // frame.setSize(gridedit.wide, gridedit.high);
        frame.setVisible(true);

        // TODO code application logic here
    }

}
