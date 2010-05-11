/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw;

import jadtgl.*;
import jadtgl.widget.*;
// import pxldrw.gui.*;
import pxldrw.logic.*;
import pxldrw.logic.Palette;
import static pxldrw.tools.Puts.*;
import pxldrw.logic.*;
import static pxldrw.tools.Puts.*;



/**
 *
 * @author bjmey
 */
public class Main {
	public interface Frobnicate {
		long frobnicate(long a, long b);		
	}
	
	public static class Frob implements Frobnicate {
		public long remember;
		
		public long frobnicate(long a, long b) {			
			long result =  a * b - remember;
			remember = a;
			return result;			
		}
		
		public static Frobnicate make() {
			return new Frob();
		}
	}
	
	public static class Frob2 extends Frob {
		public long frobnicate(long a, long b) {			
			long result =  a * b - remember;
			remember = b;
			return result;			
		}
	}

	public static final long repeats 		= 10000000;  
	static long etc			= 0;
	
	public static void measure_overhead() {
		
		long index			= 0;
    	long start 			= System.nanoTime();    	
    	for(index = 0 ; index < repeats ; index ++) {    		
    	}
    	long stop 			= System.nanoTime();
    	long delta 			= stop - start;
    	printf("Overhead: %d %d %d\n", repeats, delta, delta / repeats);		
	}
	
	public static void measure_direct() {		
		Frob frob			= new Frob();	
		long index			= 0;
    	long start 			= System.nanoTime();    	
    	for(index = 0 ; index < repeats ; index ++) {
    		etc = frob.frobnicate(index, repeats);
    	}
    	long stop 			= System.nanoTime();
    	long delta 			= stop - start;
    	printf("Direct: %d %d %d\n", repeats, delta, delta / repeats);		
	}
	
	public static void measure_interface() {
		Frobnicate frobni   = Frob.make();
		long index			= 0;
    	long start 			= System.nanoTime();    	
    	for(index = 0 ; index < repeats ; index ++) {    		
    		etc = frobni.frobnicate(index, repeats);
    	}
    	long stop 			= System.nanoTime();
    	long delta 			= stop - start;
    	printf("Interface: %d %d %d\n", repeats, delta, delta / repeats);		
	}
	
	public static void measure_inherited() {		
		Frob frob			= new Frob2();	
		long index			= 0;
    	long start 			= System.nanoTime();    	
    	for(index = 0 ; index < repeats ; index ++) {
    		etc = frob.frobnicate(index, repeats);
    	}
    	long stop 			= System.nanoTime();
    	long delta 			= stop - start;
    	printf("Inherited: %d %d %d\n", repeats, delta, delta / repeats);		
	}
	
	public static void measure_allocation() {		
		long index			= 0;
    	long start 			= System.nanoTime();    	
    	for(index = 0 ; index < repeats ; index ++) {
    		Frob frob			= new Frob2();
    		frob.frobnicate(index, repeats);
    	}
    	long stop 			= System.nanoTime();
    	long delta 			= stop - start;
    	printf("Allocation: %d %d %d\n", repeats, delta, delta / repeats);		
	}
	
	public static class WrapGraphics {
		java.awt.Graphics2D handle;
		java.awt.Color lastcolor;
		
		WrapGraphics(java.awt.Graphics2D wrapped) {
			handle = wrapped;
			lastcolor = handle.getColor();
		}
		
		void box(int x, int y, int w, int h, int r, int g, int b) {
			java.awt.Color color = new java.awt.Color(r, g, b);
			if (!color.equals(lastcolor)) { 
				handle.setColor(color);
			} 
			handle.fillRect(x, y, w, h);			
		} 
		
	} 
	
	
	public static void measure_smallrect() {
		java.awt.Frame frame = new java.awt.Frame("smallrect");
		frame.setSize(640, 480);
	    java.awt.Canvas canvas = new java.awt.Canvas();
		canvas.setSize(640, 480);
		frame.add(canvas);
		//frame.setIgnoreRepaint(true);
		//canvas.setIgnoreRepaint(true);
		canvas.setVisible(true);		
		frame.setVisible(true);		
		// canvas.createBufferStrategy(1);
		// java.awt.image.BufferStrategy buffer =  canvas.getBufferStrategy();
		 
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) canvas.getGraphics();
		g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION
					,java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
		
		g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING
				,java.awt.RenderingHints.VALUE_ANTIALIAS_OFF);
		
		g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING
				,java.awt.RenderingHints.VALUE_COLOR_RENDER_SPEED);
		g2.setRenderingHint(java.awt.RenderingHints.KEY_DITHERING
				,java.awt.RenderingHints.VALUE_DITHER_DISABLE);
		g2.setRenderingHint(java.awt.RenderingHints.KEY_FRACTIONALMETRICS
				,java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
		g2.setRenderingHint(java.awt.RenderingHints.KEY_RENDERING
				,java.awt.RenderingHints.VALUE_RENDER_SPEED);
		g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL
				,java.awt.RenderingHints.VALUE_STROKE_DEFAULT);
		WrapGraphics g 		   = new WrapGraphics(g2);
		// buffer.getDrawGraphics();
		long index			= 0;
    	long start 			= System.nanoTime();    	
    	for(index = 0 ; index < repeats ; index ++) {
    		int x, y;
    		x = (int)(index % 640L);    		
    		y = (int)(index % 480L);
    		/*
    		g2.setColor(new java.awt.Color(index % 255, index % 255, index % 255));
    		g2.fillRect(x, y, 5, 5);
    		*/
    		int cg = (int)(index % 255);
    		g.box(x, y, 5, 5, cg, cg, cg);    		
    	}
    	g2.dispose();
    	// buffer.show();
    	long stop 			= System.nanoTime();
    	long delta 			= stop - start;
    	printf("Small Rects: %d %d %d\n", repeats, delta, delta / repeats);		
	}
	


	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	/*
    	measure_smallrect();
    	measure_allocation();
    	measure_overhead();
    	measure_direct();
    	measure_inherited();
    	measure_interface();  
    	*/
    	
        Palette pal         = Palette.make();
        Grid grid           = new Grid(640, 640, pal);
        //pal.add(255,255,255);
        pal.add(255, 255, 255);
        pal.add(0,0,0);
        
        grid.fill(0);

        /*
         Display disp  = jadtgl.Jadtgl.display();
        puts("Disp: ", disp);
        Window win    = disp.window("Hi jadtgl", 640, 480);
        win.graphics().color(128, 255, 64).slab(0, 0, 640, 640);
         *
         */
        
        
        Pane pane        = new Pane("Hi", 640, 480);
        Gridedit gredit  = new  Gridedit(pane, grid, 5);


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
