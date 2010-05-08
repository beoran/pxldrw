/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import pxldrw.gui.*;
import pxldrw.logic.*;
import pxldrw.logic.Palette;
import static pxldrw.tools.Puts.*;



/**
 *
 * @author bjmey
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            puts("Could not set look and feel.");
        }        
        Frame frame         = new Frame("pxldrwj", 640, 480);
        Subframe sframe     = new Subframe("Edit", 10, 10);
        Desk desk           = new Desk();
        Palette pal         = Palette.make();
        Grid grid           = new Grid(640, 640, pal);
        Gridedit gridedit   = new Gridedit(grid, 3);
        JScrollPane scroll  = new JScrollPane(gridedit);

        /* puts("Hello!" , "World!"); */
        /*
        ascrlf.Tryout a     = new ascrlf.Tryout();
        a.hello();
         *
         */
        pal.add();
        //pal.add(255,255,255);
        pal.add(0,0,0);
        grid.fill(0);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new java.awt.BorderLayout());
        sframe.addChild(scroll);
        sframe.setVisible(true);
        desk.addChild(sframe);
        desk.setVisible(true);
        frame.addChild(sframe);
        // frame.setSize(gridedit.wide, gridedit.high);
        // root.setSize(640, 480);
        
        


        frame.setVisible(true);
        /*root.add(frame);
        */
        
    }

}
