package jadtgl.awt;

import jadtgl.Graphics;

public class Image implements jadtgl.Image {
	java.awt.Image _image;
	
	public java.awt.Image awt() {
		return _image;	
	}
	
	public Image(java.awt.Image awt) {
		_image = awt;
	}
	
	@Override
	public Graphics graphics() {
		return new jadtgl.awt.Graphics(_image.getGraphics());
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public jadtgl.Image resize(int w, int h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public jadtgl.Image stretch(int w, int h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 0;
	}

}
