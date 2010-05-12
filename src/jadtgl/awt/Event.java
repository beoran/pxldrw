package jadtgl.awt;



import java.awt.AWTEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Event implements jadtgl.Event {
    /**
     *
     */
    private static final long serialVersionUID = -4239289667320836527L;
    /** Mapping arrays. */
    protected static Kind[] kindmap;
    protected static Event.Sym[] keymap;
    protected static Event.Mod[] modmap;

    protected static Kind mapKind(int id) {
        switch (id) {
            case MouseEvent.MOUSE_CLICKED:
                return Kind.MOUSE_CLICK;
            case MouseEvent.MOUSE_DRAGGED:
                return Kind.MOUSE_DRAG;
            case MouseEvent.MOUSE_PRESSED:
                return Kind.MOUSE_DOWN;
            case MouseEvent.MOUSE_RELEASED:
                return Kind.MOUSE_UP;
            case MouseEvent.MOUSE_MOVED:
                return Kind.MOUSE_MOVE;
            case MouseEvent.MOUSE_ENTERED:
                return Kind.MOUSE_IN;
            case MouseEvent.MOUSE_EXITED:
                return Kind.MOUSE_OUT;
            case MouseEvent.MOUSE_WHEEL:
                return Kind.MOUSE_WHEEL;
            case KeyEvent.KEY_PRESSED:
                return Kind.KEY_PRESS;
            case KeyEvent.KEY_RELEASED:
                return Kind.KEY_RELEASE;
            case KeyEvent.KEY_TYPED:
                return Kind.KEY_TYPE;
            case WindowEvent.WINDOW_CLOSING:
                return Kind.WIDGET_CLOSE;
            case WindowEvent.WINDOW_CLOSED:
                return Kind.WIDGET_QUIT;
            case WindowEvent.COMPONENT_MOVED:
                return Kind.WIDGET_MOVE;
            case WindowEvent.COMPONENT_RESIZED:
                return Kind.WIDGET_RESIZE;
            default:
                return Kind.UNKNOWN;
        }
    }

    protected static Sym mapSym(int sym) {
        switch (sym) {
            case KeyEvent.VK_0:
                return Sym.K_0;
            default:
                return Sym.NONE;
        }
    }
    AWTEvent _event; // the event we are wrapping.

    public Event(java.awt.AWTEvent ev) {
        _event = ev;
    }

    @Override
    public Kind kind() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Joystick joystick() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public jadtgl.Event.Key key() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public jadtgl.Event.Mouse mouse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public jadtgl.Event.Widget widget() {
        // TODO Auto-generated method stub
        return null;
    }

    public static class Mouse extends Event
            implements jadtgl.Event.Mouse {

        public Mouse(java.awt.AWTEvent ev) {
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
        public int x() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int y() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int h() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int w() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int rotation() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean up() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean wheel() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean in() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean out() {
            // TODO Auto-generated method stub
            return false;
        }
    }

    public static class Widget extends Event
            implements jadtgl.Event.Widget {

        public Widget(java.awt.AWTEvent ev) {
            super(ev);
        }

        @Override
        public boolean close() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean quit() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean resize() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean move() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public int w() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int h() {
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

    public static class Key extends Event
            implements jadtgl.Event.Key {

        public Key(java.awt.AWTEvent ev) {
            super(ev);
        }

        @Override
        public Event.Sym sym() {
            // TODO Auto-generated method stub
            return Event.Sym.NONE;
        }

        @Override
        public boolean press() {
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
        public char text() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Event.Mod mod() {
            // TODO Auto-generated method stub
            return Event.Mod.NONE;
        }

        @Override
        public boolean type() {
            // TODO Auto-generated method stub
            return false;
        }
    }

}
