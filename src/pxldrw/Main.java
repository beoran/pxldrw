/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import pxldrw.gui.swt.*;
import pxldrw.logic.*;
import static pxldrw.tools.Puts.*;
import jadtgl.*;


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
        pal.add(255, 255, 255);
        pal.add(0,0,0);
        
        grid.fill(0);
        
        Pane pane = new Pane();
/*
    	Display 	display = new Display();
    	Shell 		shell 	= new Shell(display);
    	// Composite 	area 	= new Composite(shell, SWT.NONE);
        GridLayout  layout 	= new GridLayout();
        layout.numColumns   = 1;
        //area.setLayout(layout);
    	Gridedit gridedit =	new Gridedit(shell, 0, grid, 5);
    	gridedit.setVisible(true);
    	puts((Object [])shell.getChildren());
    	
    	shell.open();
    	while(!shell.isDisposed()) {
    		if(!display.readAndDispatch()) {
    			display.sleep();	
    		}
    	}
        shell.dispose();
        display.dispose();
*/        
    }

}
