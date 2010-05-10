package pxldrw.gui.swt;




import pxldrw.logic.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import static pxldrw.tools.Puts.*;

public class Gridedit extends Canvas implements DisposeListener,
		DragDetectListener, PaintListener, MouseTrackListener, 
		MouseListener {

	Grid grid;
	int wide, zoom, high;
	static int ZOOM_MAX = 10;
	org.eclipse.swt.graphics.Color bg;
	
	
	public Gridedit(Composite parent, int style, Grid grid, int zoom) {
		super(parent, style | SWT.BORDER_SOLID);
		this.addDisposeListener(this);
		this.addDragDetectListener(this);
		this.addPaintListener(this);
		this.addMouseListener(this);	
		this.addMouseTrackListener(this);
		this.grid = grid;
		this.zoom = zoom;
		this.sizeChanged();
	}
	
    /* Call this whenever the size of the grid editor should be changed. */
    public void sizeChanged() {
        this.wide = grid.wide() * this.zoom;
        this.high = grid.high() * this.zoom;
        this.setSize(wide, high);
        this.redraw();
    }
    
    public Point computeSize(int wHint, int hHint, boolean changed) {
        return new Point(wide + 2, high + 2);    
     }

    /** Sets the current zoom factor of the grid editor. */
    public int zoom(int z) {
        if (z < 1 || z > ZOOM_MAX ) return this.zoom;
        this.zoom = z;
        this.sizeChanged();
        this.redraw();
        return this.zoom;
    }

    /** Returns the current zoom factor of the grid editor. */
    public int zoom() {
        return this.zoom;
    }
    
    @Override
    public void drawBackground(GC gc, int x, int y, int w, int h) {
    }

	@Override
	public void paintControl(PaintEvent e) {
		GC gc    = e.gc;
		Rectangle bounds = this.getParent().getBounds();
        gc.setClipping(bounds);
        // printf("Painting! %d %d, %d %d\n", bounds.x, bounds.y, bounds.width, bounds.height);
        int x, y, gy, gx;
        
        for (gy = 0 ; gy < grid.high() ; gy ++) {
            y = gy * zoom;
            for (gx = 0 ; gx < grid.wide() ; gx++) {
                x = gx * zoom;
                Rectangle drawrect = new Rectangle(x, y, zoom, zoom);
                if (!bounds.intersects(drawrect)) {
                    continue;
                }

                pxldrw.logic.Color c = grid.get(gx, gy);
                if (c == null)  { continue; }
                org.eclipse.swt.graphics.Color color =
                   new org.eclipse.swt.graphics.Color(this.getDisplay(), 
                		   c.R(), c.G(), c.B());                
                if (c.transparent()) { continue; }
                gc.setBackground(color);
                gc.fillRectangle(x, y, zoom, zoom);
                color.dispose();
            }
        }

    }

	public void set(int x, int y, int index) {
		int gridx, gridy;
		gridx = x / zoom;
		gridy = y / zoom;
		grid.set(gridx, gridy, index);
		this.redraw();
	}
	
	@Override
	public void widgetDisposed(DisposeEvent e) {
	}

	@Override
	public void dragDetected(DragDetectEvent e) {
		this.set(e.x, e.y, 1);
		puts("Drag ok!", e.x, e.y);
	}



	@Override
	public void mouseEnter(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExit(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseHover(MouseEvent e) {
		this.set(e.x, e.y, 1);
		puts("Hover ok!", e.x, e.y);		
		// TODO Auto-generated method stub

	}

	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	public void mouseDown(MouseEvent e) { 
		this.set(e.x, e.y, 1);
		puts("Down ok!", e.x, e.y);
	}

	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

}
