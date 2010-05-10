package jadtgl.awt;

import jadtgl.Platform.Font;
import jadtgl.Platform.Image;
import jadtgl.Platform.Paint;

public class Graphics implements jadtgl.Platform.Graphics {
	java.awt.Graphics2D handle;
	
	
	Graphics(java.awt.Graphics2D g2d) {
		handle = g2d;		
	}
	

	@Override
	public jadtgl.Platform.Graphics blit(int x, int y, Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics box(int x, int y, int w, int h, Paint color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics circle(int x, int y, int w, int h,
			Paint color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics disk(int x, int y, int w, int h, Paint color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics line(int x, int y, int w, int h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics rectangle(int x, int y, int w, int h,
			Paint color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics stretch(int x, int y, int w, int h,
			Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Platform.Graphics text(int x, int y, Font font, Paint color,
			String utf8) {
		// TODO Auto-generated method stub
		return null;
	}

}
