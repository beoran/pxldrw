package jadtgl;


/** Models a generic color independent from platform-specific colors.
 */
public interface Color extends Paint {
	int r();
	int g();
	int b();
	int a();
	boolean transparent();
	boolean opaque();
}