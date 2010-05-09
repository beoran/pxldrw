package pxldrw.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;

import pxldrw.logic.*;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class GrideditSWT extends org.eclipse.swt.widgets.Canvas
implements DisposeListener, PaintListener, DragDetectListener {

	public static final int ZOOM_MAX = 20;
    public Grid grid;
    public int wide, high;
    public int zoom;

	
	public GrideditSWT(Composite parent, int style, Grid grid, int zoom) {
		super(parent, style);
		this.grid = grid;
		this.zoom = zoom;
		
		this.sizeChanged();
		this.addDisposeListener(this);
		this.addPaintListener(this);
		this.addDragDetectListener(this);
		// TODO Auto-generated constructor stub
	}
	
    /* Call this whenever the size of the grid editor should be changed. */
    public void sizeChanged() {
        this.wide = grid.wide() * this.zoom;
        this.high = grid.high() * this.zoom;
        this.setSize(wide, high);
    }

	@Override
	public void widgetDisposed(DisposeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintControl(PaintEvent e) {
		// TODO Auto-generated method stub
		GC g2 = e.gc;
		
	       Graphics2D g2 = (Graphics2D) g;
	        int x, y, gy, gx;
	        // printf("Painting! %d %d\n", grid.high(), grid.wide());
	        for (gy = 0 ; gy < grid.high() ; gy ++) {
	            y = gy * zoom;
	            for (gx = 0 ; gx < grid.wide() ; gx++) {
	                x = gx * zoom;                
	                pxldrw.logic.Color gc = grid.get(gx, gy);
	                if (gc == null) { continue; }
	                java.awt.Color col = gc.awt();
	                if (col == null) { continue; }
	                g2.setPaint(col);
	                g2.fillRect(x, y, zoom, zoom);
	            }
	        }
	}

	@Override
	public void dragDetected(DragDetectEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    

	

}
