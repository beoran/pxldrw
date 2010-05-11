package jadtgl.widget;

import jadtgl.Graphics;
import jadtgl.Handler;
import jadtgl.Widget;
import jadtgl.Window;
import jadtgl.Handler.Reply;

public class BasicWidget implements Widget  {
	
	Window 	_window;
	Handler _handler;
	Widget  _parent;
	java.util.ArrayList<Widget> _widgets; 
	
	public BasicWidget(Window window) {
		this.window(window);
		_widgets = new java.util.ArrayList<Widget>();
	}
	
	public BasicWidget() {
		this(jadtgl.Jadtgl.display().defaultwindow());
		_parent = null;
	}
	
	public BasicWidget(Widget parent) {
		this(parent.window());
		_parent = parent;
                _parent.add(this);
	}
	
	/** Adds a child widget to this widget and returns it. */
	public Widget add(Widget widget) {
		_widgets.add(widget);
		return widget;
	}
	
	int width() {
		return 640;
	}
	
	int height() {
		return 480;
	}
	
	
	/** Draws the widget itself, but not it's children or parent. 
	 * Draws a white rectangle by default. 
	 **/
	public void draw(Graphics graphics) {
		graphics.color(255,255,255).slab(0, 0, height(), width());
	}
	
	
	@Override
	public void drawAll(Graphics graphics) {
            draw(graphics);
            for (Widget w : _widgets) {
            	w.drawAll(graphics);
            }
	}

	@Override
	public Widget root() {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Window window(Window window) {
            _window = window;
            return window();
	}

	@Override
	public Window window() {
            return _window;
	}
	
	
	@Override
	public Reply onKeyDown(char text, int keycode) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onKeyType(char text, int keycode) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onKeyUp(char text, int keycode) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseClick(int x, int y, int buttons) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseDown(int x, int y, int buttons) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseDrag(int x, int y, int buttons) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseUp(int x, int y, int buttons) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onWindowClose() {
            // TODO Auto-generated method stub
            return null;
	}
	
	@Override
	public Reply onWindowQuit() {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseEnter(int x, int y, int button) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseLeave(int x, int y, int button) {
            // TODO Auto-generated method stub
            return null;
	}

	@Override
	public Reply onMouseMove(int x, int y, int button) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reply onMouseWheel(int x, int y, int button, int by) {
		// TODO Auto-generated method stub
		return null;
	}


}
