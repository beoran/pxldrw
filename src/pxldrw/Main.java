/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw;
import org.eclipse.swt.widgets.*;
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
        Palette pal         = Palette.make();
        Grid grid           = new Grid(640, 640, pal);
        //pal.add(255,255,255);
        pal.add(0,0,0);
        grid.fill(0);

    	Display display = new Display();
    	Shell shell = new Shell(display);
    	pxldrw.gui.swt.Gridedit gridedit = 
    		new pxldrw.gui.swt.Gridedit(shell, 0, grid, 5);
    	       pal.add();
    	shell.open();
    	while(!shell.isDisposed()) {
    		display.sleep();
    		display.readAndDispatch();
    	}
        shell.dispose();
        display.dispose();
    }

}
