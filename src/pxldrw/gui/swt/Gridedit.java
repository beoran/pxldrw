package pxldrw.gui.swt;




import pxldrw.logic.*;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Gridedit extends Canvas implements DisposeListener,
		DragDetectListener, PaintListener, MouseTrackListener {

	Grid grid;
	int wide, zoom, high;
	static int ZOOM_MAX = 10;
	
	public Gridedit(Composite parent, int style, Grid grid, int zoom) {
		super(parent, style);
		this.addDisposeListener(this);
		this.addDragDetectListener(this);
		this.addPaintListener(this);
		this.grid = grid;
		this.zoom = zoom;
	}
	
    /* Call this whenever the size of the grid editor should be changed. */
    public void sizeChanged() {
        this.wide = grid.wide() * this.zoom;
        this.high = grid.high() * this.zoom;
        this.setSize(wide, high);
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
	public void paintControl(PaintEvent e) {
		GC g2    = e.gc;
		Rectangle bounds = this.getBounds();
        int x, y, gy, gx;
        // printf("Painting! %d %d\n", grid.high(), grid.wide());
        for (gy = 0 ; gy < grid.high() ; gy ++) {
            y = gy * zoom;
            for (gx = 0 ; gx < grid.wide() ; gx++) {
                x = gx * zoom;
                Rectangle drawrect = new Rectangle(x, y, zoom, zoom);
                if (!bounds.intersects(drawrect)) {
                    continue;
                }

                pxldrw.logic.Color gc = grid.get(gx, gy);
                if (gc == null)  { continue; }
                org.eclipse.swt.graphics.Color color =
                   new org.eclipse.swt.graphics.Color(this.getDisplay(), 
                		   gc.R(), gc.G(), gc.B());
                g2.setForeground(color);
                g2.fillRectangle(x, y, zoom, zoom);
                color.dispose();
            }
        }

    }

	
	@Override
	public void widgetDisposed(DisposeEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragDetected(DragDetectEvent e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
