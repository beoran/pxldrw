package jadtgl.widget;
import pxldrw.logic.*;

import jadtgl.widget.*;
import jadtgl.*;

public class Gridedit extends BasicWidget {

    public static final int ZOOM_MAX = 20;
    public Grid grid;
    public int wide, high;
    public int zoom;

    public Gridedit(Widget parent, Grid grid, int zoom) {
	super(parent);
	this.grid = grid;
	this.zoom = zoom;
		
	this.sizeChanged();
	// TODO Auto-generated constructor stub
    }
	
    /* Call this whenever the size of the grid editor should be changed. */
    public void sizeChanged() {
        this.wide = grid.wide() * this.zoom;
        this.high = grid.high() * this.zoom;
        // this.setSize(wide, high);
    }

    @Override
    public void draw(Graphics g) {
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
                g.color(gc.R(), gc.G(), gc.B()).slab(x, y, zoom, zoom);
            }
        }
    }

    @Override
    public Handler.Reply onMouseDrag(int x, int y, int buttons) {
        grid.set(x / zoom, y /zoom, 1);
        return Handler.Status.OK;
    }
    
    

	

}
