package pxldrw.logic;

/**
 * Clear is the transparent color. It is a singleton which is accessed by using Clear.make
 * @author bjmey
 */
public class Clear implements Color {
    private Clear() {
        
    }
    
    public static Color make() {
        return new Clear();
    }

    public boolean transparent() {
        return true;
    }

    public boolean opaque() {
       return false;
    }

    public java.awt.Color awt() {
        return null;
    }

    public java.awt.Color awt(boolean grayscale) {
        return null;
    }

	public int B() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int G() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int R() {
		// TODO Auto-generated method stub
		return 0;
	}

}
