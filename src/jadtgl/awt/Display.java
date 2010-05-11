package jadtgl.awt;


import jadtgl.Font;
import jadtgl.Image;
import jadtgl.Window;

public class Display implements jadtgl.Display {

	/** The windows that have been created by the system */
	java.util.ArrayList<Window> _windows;
	
	public Display() {
		_windows = new java.util.ArrayList<Window>();
	}
	
	@Override
	public Font defaultfont(int size) {
		return new jadtgl.awt.Font("Serif", 12);
	}

	@Override
	public String[] fontnames() {
		java.awt.GraphicsEnvironment e = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
	    String[] result = e.getAvailableFontFamilyNames(); 
		return result;
	}

	@Override
	public Image image(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Window window(String title, int w, int h) {
		Window last = new jadtgl.awt.Window(title, w, h);
		_windows.add(last); // remember we have created the window. 
		return last; 
	}

	@Override
	public Font font(String fontname, int size) {
		return new jadtgl.awt.Font(fontname, size);		
	}

	@Override
	public Window defaultwindow() {
		for (Window win : _windows) {
			if (win.active()) return win;			
		}
		return null;
	}

}
