/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw;

import pxldrw.gui.*;
import pxldrw.logic.*;
import pxldrw.logic.Palette;


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
        Palette pal          = Palette.make();
        Grid grid           = new Grid(64, 64, pal);
        Gridedit gridedit   = new Gridedit(grid);
        /* puts("Hello!" , "World!"); */
        /*
        ascrlf.Tryout a     = new ascrlf.Tryout();
        a.hello();
         *
         */
        pal.add(255,255,255);
        pal.add(0,0,0);
        grid.fill(0);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.BorderLayout());
        frame.addChild(gridedit);
        // frame.setSize(gridedit.wide, gridedit.high);
        frame.setVisible(true);

    }

}
