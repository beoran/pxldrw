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
            case KeyEvent.VK_ENTER	: return Sym.K_ENTER;
            case KeyEvent.VK_BACK_SPACE	: return Sym.K_BACK_SPACE;
            case KeyEvent.VK_TAB	: return Sym.K_TAB;
            case KeyEvent.VK_CANCEL	: return Sym.K_CANCEL;
            case KeyEvent.VK_CLEAR	: return Sym.K_CLEAR;
            case KeyEvent.VK_SHIFT	: return Sym.K_SHIFT;
            case KeyEvent.VK_CONTROL	: return Sym.K_CONTROL;
            case KeyEvent.VK_ALT	: return Sym.K_ALT;
            case KeyEvent.VK_PAUSE	: return Sym.K_PAUSE;
            case KeyEvent.VK_CAPS_LOCK	: return Sym.K_CAPS_LOCK;
            case KeyEvent.VK_ESCAPE	: return Sym.K_ESCAPE;
            case KeyEvent.VK_SPACE	: return Sym.K_SPACE;
            case KeyEvent.VK_PAGE_UP	: return Sym.K_PAGE_UP;
            case KeyEvent.VK_PAGE_DOWN	: return Sym.K_PAGE_DOWN;
            case KeyEvent.VK_END	: return Sym.K_END;
            case KeyEvent.VK_HOME	: return Sym.K_HOME;
            case KeyEvent.VK_LEFT	: return Sym.K_LEFT;
            case KeyEvent.VK_UP	: return Sym.K_UP;
            case KeyEvent.VK_RIGHT	: return Sym.K_RIGHT;
            case KeyEvent.VK_DOWN	: return Sym.K_DOWN;
            case KeyEvent.VK_COMMA	: return Sym.K_COMMA;
            case KeyEvent.VK_MINUS	: return Sym.K_MINUS;
            case KeyEvent.VK_PERIOD	: return Sym.K_PERIOD;
            case KeyEvent.VK_SLASH	: return Sym.K_SLASH;
            case KeyEvent.VK_0	: return Sym.K_0;
            case KeyEvent.VK_1	: return Sym.K_1;
            case KeyEvent.VK_2	: return Sym.K_2;
            case KeyEvent.VK_3	: return Sym.K_3;
            case KeyEvent.VK_4	: return Sym.K_4;
            case KeyEvent.VK_5	: return Sym.K_5;
            case KeyEvent.VK_6	: return Sym.K_6;
            case KeyEvent.VK_7	: return Sym.K_7;
            case KeyEvent.VK_8	: return Sym.K_8;
            case KeyEvent.VK_9	: return Sym.K_9;
            case KeyEvent.VK_SEMICOLON	: return Sym.K_SEMICOLON;
            case KeyEvent.VK_EQUALS	: return Sym.K_EQUALS;
            case KeyEvent.VK_A	: return Sym.K_A;
            case KeyEvent.VK_B	: return Sym.K_B;
            case KeyEvent.VK_C	: return Sym.K_C;
            case KeyEvent.VK_D	: return Sym.K_D;
            case KeyEvent.VK_E	: return Sym.K_E;
            case KeyEvent.VK_F	: return Sym.K_F;
            case KeyEvent.VK_G	: return Sym.K_G;
            case KeyEvent.VK_H	: return Sym.K_H;
            case KeyEvent.VK_I	: return Sym.K_I;
            case KeyEvent.VK_J	: return Sym.K_J;
            case KeyEvent.VK_K	: return Sym.K_K;
            case KeyEvent.VK_L	: return Sym.K_L;
            case KeyEvent.VK_M	: return Sym.K_M;
            case KeyEvent.VK_N	: return Sym.K_N;
            case KeyEvent.VK_O	: return Sym.K_O;
            case KeyEvent.VK_P	: return Sym.K_P;
            case KeyEvent.VK_Q	: return Sym.K_Q;
            case KeyEvent.VK_R	: return Sym.K_R;
            case KeyEvent.VK_S	: return Sym.K_S;
            case KeyEvent.VK_T	: return Sym.K_T;
            case KeyEvent.VK_U	: return Sym.K_U;
            case KeyEvent.VK_V	: return Sym.K_V;
            case KeyEvent.VK_W	: return Sym.K_W;
            case KeyEvent.VK_X	: return Sym.K_X;
            case KeyEvent.VK_Y	: return Sym.K_Y;
            case KeyEvent.VK_Z	: return Sym.K_Z;
            case KeyEvent.VK_OPEN_BRACKET	: return Sym.K_OPEN_BRACKET;
            case KeyEvent.VK_BACK_SLASH	: return Sym.K_BACK_SLASH;
            case KeyEvent.VK_CLOSE_BRACKET	: return Sym.K_CLOSE_BRACKET;
            case KeyEvent.VK_NUMPAD0	: return Sym.K_NUMPAD0;
            case KeyEvent.VK_NUMPAD1	: return Sym.K_NUMPAD1;
            case KeyEvent.VK_NUMPAD2	: return Sym.K_NUMPAD2;
            case KeyEvent.VK_NUMPAD3	: return Sym.K_NUMPAD3;
            case KeyEvent.VK_NUMPAD4	: return Sym.K_NUMPAD4;
            case KeyEvent.VK_NUMPAD5	: return Sym.K_NUMPAD5;
            case KeyEvent.VK_NUMPAD6	: return Sym.K_NUMPAD6;
            case KeyEvent.VK_NUMPAD7	: return Sym.K_NUMPAD7;
            case KeyEvent.VK_NUMPAD8	: return Sym.K_NUMPAD8;
            case KeyEvent.VK_NUMPAD9	: return Sym.K_NUMPAD9;
            case KeyEvent.VK_MULTIPLY	: return Sym.K_MULTIPLY;
            case KeyEvent.VK_ADD	: return Sym.K_ADD;
            case KeyEvent.VK_SEPARATOR	: return Sym.K_SEPARATOR;
            case KeyEvent.VK_SUBTRACT	: return Sym.K_SUBTRACT;
            case KeyEvent.VK_DECIMAL	: return Sym.K_DECIMAL;
            case KeyEvent.VK_DIVIDE	: return Sym.K_DIVIDE;
            case KeyEvent.VK_DELETE	: return Sym.K_DELETE;
            case KeyEvent.VK_NUM_LOCK	: return Sym.K_NUM_LOCK;
            case KeyEvent.VK_SCROLL_LOCK	: return Sym.K_SCROLL_LOCK;
            case KeyEvent.VK_F1	: return Sym.K_F1;
            case KeyEvent.VK_F2	: return Sym.K_F2;
            case KeyEvent.VK_F3	: return Sym.K_F3;
            case KeyEvent.VK_F4	: return Sym.K_F4;
            case KeyEvent.VK_F5	: return Sym.K_F5;
            case KeyEvent.VK_F6	: return Sym.K_F6;
            case KeyEvent.VK_F7	: return Sym.K_F7;
            case KeyEvent.VK_F8	: return Sym.K_F8;
            case KeyEvent.VK_F9	: return Sym.K_F9;
            case KeyEvent.VK_F10	: return Sym.K_F10;
            case KeyEvent.VK_F11	: return Sym.K_F11;
            case KeyEvent.VK_F12	: return Sym.K_F12;
            case KeyEvent.VK_F13	: return Sym.K_F13;
            case KeyEvent.VK_F14	: return Sym.K_F14;
            case KeyEvent.VK_F15	: return Sym.K_F15;
            case KeyEvent.VK_F16	: return Sym.K_F16;
            case KeyEvent.VK_F17	: return Sym.K_F17;
            case KeyEvent.VK_F18	: return Sym.K_F18;
            case KeyEvent.VK_F19	: return Sym.K_F19;
            case KeyEvent.VK_F20	: return Sym.K_F20;
            case KeyEvent.VK_F21	: return Sym.K_F21;
            case KeyEvent.VK_F22	: return Sym.K_F22;
            case KeyEvent.VK_F23	: return Sym.K_F23;
            case KeyEvent.VK_F24	: return Sym.K_F24;
            case KeyEvent.VK_PRINTSCREEN	: return Sym.K_PRINTSCREEN;
            case KeyEvent.VK_INSERT	: return Sym.K_INSERT;
            case KeyEvent.VK_HELP	: return Sym.K_HELP;
            case KeyEvent.VK_META	: return Sym.K_META;
            case KeyEvent.VK_BACK_QUOTE	: return Sym.K_BACK_QUOTE;
            case KeyEvent.VK_QUOTE	: return Sym.K_QUOTE;
            case KeyEvent.VK_KP_UP	: return Sym.K_KP_UP;
            case KeyEvent.VK_KP_DOWN	: return Sym.K_KP_DOWN;
            case KeyEvent.VK_KP_LEFT	: return Sym.K_KP_LEFT;
            case KeyEvent.VK_KP_RIGHT	: return Sym.K_KP_RIGHT;
            case KeyEvent.VK_DEAD_GRAVE	: return Sym.K_DEAD_GRAVE;
            case KeyEvent.VK_DEAD_ACUTE	: return Sym.K_DEAD_ACUTE;
            case KeyEvent.VK_DEAD_CIRCUMFLEX	: return Sym.K_DEAD_CIRCUMFLEX;
            case KeyEvent.VK_DEAD_TILDE	: return Sym.K_DEAD_TILDE;
            case KeyEvent.VK_DEAD_MACRON	: return Sym.K_DEAD_MACRON;
            case KeyEvent.VK_DEAD_BREVE	: return Sym.K_DEAD_BREVE;
            case KeyEvent.VK_DEAD_ABOVEDOT	: return Sym.K_DEAD_ABOVEDOT;
            case KeyEvent.VK_DEAD_DIAERESIS	: return Sym.K_DEAD_DIAERESIS;
            case KeyEvent.VK_DEAD_ABOVERING	: return Sym.K_DEAD_ABOVERING;
            case KeyEvent.VK_DEAD_DOUBLEACUTE	: return Sym.K_DEAD_DOUBLEACUTE;
            case KeyEvent.VK_DEAD_CARON	: return Sym.K_DEAD_CARON;
            case KeyEvent.VK_DEAD_CEDILLA	: return Sym.K_DEAD_CEDILLA;
            case KeyEvent.VK_DEAD_OGONEK	: return Sym.K_DEAD_OGONEK;
            case KeyEvent.VK_DEAD_IOTA	: return Sym.K_DEAD_IOTA;
            case KeyEvent.VK_DEAD_VOICED_SOUND	: return Sym.K_DEAD_VOICED_SOUND;
            case KeyEvent.VK_DEAD_SEMIVOICED_SOUND	: return Sym.K_DEAD_SEMIVOICED_SOUND;
            case KeyEvent.VK_AMPERSAND	: return Sym.K_AMPERSAND;
            case KeyEvent.VK_ASTERISK	: return Sym.K_ASTERISK;
            case KeyEvent.VK_QUOTEDBL	: return Sym.K_QUOTEDBL;
            case KeyEvent.VK_LESS	: return Sym.K_LESS;
            case KeyEvent.VK_GREATER	: return Sym.K_GREATER;
            case KeyEvent.VK_BRACELEFT	: return Sym.K_BRACELEFT;
            case KeyEvent.VK_BRACERIGHT	: return Sym.K_BRACERIGHT;
            case KeyEvent.VK_AT	: return Sym.K_AT;
            case KeyEvent.VK_COLON	: return Sym.K_COLON;
            case KeyEvent.VK_CIRCUMFLEX	: return Sym.K_CIRCUMFLEX;
            case KeyEvent.VK_DOLLAR	: return Sym.K_DOLLAR;
            case KeyEvent.VK_EURO_SIGN	: return Sym.K_EURO_SIGN;
            case KeyEvent.VK_EXCLAMATION_MARK	: return Sym.K_EXCLAMATION_MARK;
            case KeyEvent.VK_INVERTED_EXCLAMATION_MARK	: return Sym.K_INVERTED_EXCLAMATION_MARK;
            case KeyEvent.VK_LEFT_PARENTHESIS	: return Sym.K_LEFT_PARENTHESIS;
            case KeyEvent.VK_NUMBER_SIGN	: return Sym.K_NUMBER_SIGN;
            case KeyEvent.VK_PLUS	: return Sym.K_PLUS;
            case KeyEvent.VK_RIGHT_PARENTHESIS	: return Sym.K_RIGHT_PARENTHESIS;
            case KeyEvent.VK_UNDERSCORE	: return Sym.K_UNDERSCORE;
            case KeyEvent.VK_WINDOWS	: return Sym.K_WINDOWS;
            case KeyEvent.VK_CONTEXT_MENU	: return Sym.K_CONTEXT_MENU;
            case KeyEvent.VK_FINAL	: return Sym.K_FINAL;
            case KeyEvent.VK_CONVERT	: return Sym.K_CONVERT;
            case KeyEvent.VK_NONCONVERT	: return Sym.K_NONCONVERT;
            case KeyEvent.VK_ACCEPT	: return Sym.K_ACCEPT;
            case KeyEvent.VK_MODECHANGE	: return Sym.K_MODECHANGE;
            case KeyEvent.VK_KANA	: return Sym.K_KANA;
            case KeyEvent.VK_KANJI	: return Sym.K_KANJI;
            case KeyEvent.VK_ALPHANUMERIC	: return Sym.K_ALPHANUMERIC;
            case KeyEvent.VK_KATAKANA	: return Sym.K_KATAKANA;
            case KeyEvent.VK_HIRAGANA	: return Sym.K_HIRAGANA;
            case KeyEvent.VK_FULL_WIDTH	: return Sym.K_FULL_WIDTH;
            case KeyEvent.VK_HALF_WIDTH	: return Sym.K_HALF_WIDTH;
            case KeyEvent.VK_ROMAN_CHARACTERS	: return Sym.K_ROMAN_CHARACTERS;
            case KeyEvent.VK_ALL_CANDIDATES	: return Sym.K_ALL_CANDIDATES;
            case KeyEvent.VK_PREVIOUS_CANDIDATE	: return Sym.K_PREVIOUS_CANDIDATE;
            case KeyEvent.VK_CODE_INPUT	: return Sym.K_CODE_INPUT;
            case KeyEvent.VK_JAPANESE_KATAKANA	: return Sym.K_JAPANESE_KATAKANA;
            case KeyEvent.VK_JAPANESE_HIRAGANA	: return Sym.K_JAPANESE_HIRAGANA;
            case KeyEvent.VK_JAPANESE_ROMAN	: return Sym.K_JAPANESE_ROMAN;
            case KeyEvent.VK_KANA_LOCK	: return Sym.K_KANA_LOCK;
            case KeyEvent.VK_INPUT_METHOD_ON_OFF	: return Sym.K_INPUT_METHOD_ON_OFF;
            case KeyEvent.VK_CUT	: return Sym.K_CUT;
            case KeyEvent.VK_COPY	: return Sym.K_COPY;
            case KeyEvent.VK_PASTE	: return Sym.K_PASTE;
            case KeyEvent.VK_UNDO	: return Sym.K_UNDO;
            case KeyEvent.VK_AGAIN	: return Sym.K_AGAIN;
            case KeyEvent.VK_FIND	: return Sym.K_FIND;
            case KeyEvent.VK_PROPS	: return Sym.K_PROPS;
            case KeyEvent.VK_STOP	: return Sym.K_STOP;
            case KeyEvent.VK_COMPOSE	: return Sym.K_COMPOSE;
            case KeyEvent.VK_ALT_GRAPH	: return Sym.K_ALT_GRAPH;
            case KeyEvent.VK_BEGIN	: return Sym.K_BEGIN;
            case KeyEvent.VK_UNDEFINED	: return Sym.K_UNDEFINED;
            default:  return Sym.NONE;
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
