package jadtgl.awt;

import java.awt.AWTEvent;

public class Event extends AWTEvent 
implements jadtgl.Platform.Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4239289667320836527L;

	Event(java.awt.Event ev) {
		super(ev);
	}

	@Override
	public int buttons() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean click() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean down() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public jadtgl.Platform.Event eat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eaten() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finish() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int key() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean keyboard() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Kind kind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mouse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean press() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean release() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean repeat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String text() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean type() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean up() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int w() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int x() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int y() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
