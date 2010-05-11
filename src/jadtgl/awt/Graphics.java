package jadtgl.awt;

import jadtgl.Font;
import jadtgl.Image;
import jadtgl.Paint;

public class Graphics implements jadtgl.Graphics {
	java.awt.Graphics2D handle;
	java.awt.Color 		_color;
	java.awt.Font		_font;
	
	Graphics(java.awt.Graphics2D g2d) {
		handle 		= g2d;	
		_color 		= handle.getColor(); // cache the color since setColor is SLOOOOW
		_font		= handle.getFont(); // same for font
	}
	
	@Override
	public jadtgl.Graphics color(int r, int g, int b) {
		Paint color = new jadtgl.awt.Color(r, g, b, 255);
		return this.color(color);
	}

	@Override
	public jadtgl.Graphics color(int r, int g, int b, int a) {		
		Paint color = new jadtgl.awt.Color(r, g, b, a);
		return this.color(color);
	}

	
	Graphics(java.awt.Graphics g) {
		this((java.awt.Graphics2D) g);		
	}
	
	java.awt.Graphics2D awt() {
		return handle;
	}

	public Graphics color(Paint color) {
		java.awt.Color awtcolor = (java.awt.Color) color;
		if(_color.equals(awtcolor)) return this;
		handle.setColor(awtcolor);
		_color = awtcolor;
		return this;
	}
	
	@Override
	public jadtgl.Graphics blit(int x, int y, Image image) {
		java.awt.Image awtimage = (java.awt.Image) image; 
		handle.drawImage(awtimage, x, y, null);
		return this;
	}

	@Override
	public jadtgl.Graphics slab(int x, int y, int w, int h) {  
		// set the color on the handle if it is different from the old one.
		handle.fillRect(x, y, w, h);
		// and draw
		return this;
	}

	@Override
	public jadtgl.Graphics oval(int x, int y, int w, int h) {
		// set the color on the handle if it is different from the old one.
		handle.drawOval(x, y, w, h);
		// and draw
		return this;
	}

	@Override
	public jadtgl.Graphics disk(int x, int y, int w, int h) {
		// set the color on the handle if it is different from the old one.
		handle.fillOval(x, y, w, h);
		// and draw
		return this;
	}

	@Override
	public jadtgl.Graphics line(int x, int y, int w, int h) {
		// set the color on the handle if it is different from the old one.
		handle.drawLine(x, y, w, h);
		// and draw
		return this;
	}

	@Override
	public jadtgl.Graphics rectangle(int x, int y, int w, int h) {
		handle.drawRect(x, y, w, h);
		return this;
	}

	@Override
	public jadtgl.Graphics stretch(int x, int y, int w, int h,	Image image) {
		jadtgl.awt.Image gimage = (jadtgl.awt.Image) image; 
		java.awt.Image awtimage = gimage.awt(); 
		handle.drawImage(awtimage, x, y, w, h, null);
		return this;
	}

	@Override
	public jadtgl.Graphics text(int x, int y, String utf8) {
		handle.drawString(utf8, x, y);
		return this;
	}

	@Override
	public jadtgl.Graphics font(Font font) {
		jadtgl.awt.Font gfont   = (jadtgl.awt.Font) font;
		java.awt.Font   awtfont = gfont.awt();
	    if (_font.equals(awtfont)) return this;
		handle.setFont(awtfont);
		_font = awtfont;
		return this;
	}

	
}
