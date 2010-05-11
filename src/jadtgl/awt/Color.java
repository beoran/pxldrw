package jadtgl.awt;


public class Color extends java.awt.Color 
implements jadtgl.Color {

	private static final long serialVersionUID = -2957542802622847242L;

	public Color(int r, int g, int b, int a) {
		super(r, g, b , a);
	}

	@Override
	public int a() {
		// TODO Auto-generated method stub
		return this.getAlpha();
	}

	@Override
	public int b() {
		// TODO Auto-generated method stub
		return this.getBlue();
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return this.getGreen();
	}

	@Override
	public boolean opaque() {
		// TODO Auto-generated method stub
		return this.a() == 255;
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return this.getRed();
	}

	@Override
	public boolean transparent() {
		// TODO Auto-generated method stub
		return this.a() == 0;
	}
	
	

}
