package jadtgl.widget;

import jadtgl.*;
import jadtgl.widget.*;
import static pxldrw.tools.Puts.*;

public class Pane extends BasicWidget  {
    public Pane(String title, int w, int h) {
        this.window(jadtgl.Jadtgl.display().window(title, w, h));
        this.window().widget(this);
    }
        

}
