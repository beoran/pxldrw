package jadtgl.awt;




public class Font implements jadtgl.Font {

	private static final long serialVersionUID = 2010205489334004547L;

	java.awt.Font _font;
	
	public Font(String name, int size) {
		_font = new java.awt.Font(name, java.awt.Font.PLAIN, size);
	}
	
	/** Returns the underlying AWT object. */
	public java.awt.Font awt() {
		return _font;
	}

	@Override
	public int height(String utf8) {
		// TODO Auto-generated method stub
		return _font.getSize();
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return _font.getName();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return _font.getSize();
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
