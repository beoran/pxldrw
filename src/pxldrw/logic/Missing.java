/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pxldrw.logic;

/**
 * Missing is the missing color that is used to represent colors that have been remocved from a palette
 * @author bjmey
 */
public class Missing implements Color {

    // the index that the missing color used to have
    protected int index;

    public Missing(int index) {
        this.index = index;
    }

    public boolean transparent() {
        return false;
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

}
