package jadtgl.awt;


public class Font extends java.awt.Font 
implements jadtgl.Platform.Font {

	private static final long serialVersionUID = 2010205489334004547L;

	public Font(java.awt.Font font) {
		super(font);
	}

	@Override
	public int height(String utf8) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.getName();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.getSize();
	}

	@Override
	public int space() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int width(String utf8) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
