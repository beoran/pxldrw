package jadtgl;

/** 
 * Events which the platform may send to the widgets. It's simplified so one event 
 * size "fits all" so to speak. 
 */
public interface Event {

    enum Kind {

        MOUSE_UP, MOUSE_DOWN, MOUSE_CLICK, MOUSE_MOVE, MOUSE_DRAG,
        MOUSE_IN, MOUSE_OUT, MOUSE_WHEEL,
        KEY_PRESS, KEY_RELEASE, KEY_TYPE,
        WIDGET_CLOSE, WIDGET_QUIT, WIDGET_RESIZE, WIDGET_MOVE,
        JOYSTICK_AXIS, JOYSTICK_DOWN, JOYSTICK_UP, UNKNOWN
    };

    /** The kind of event. */
    Event.Kind kind();

    /** Returns a Event.Mouse if this is a mouse event, or null if not. */
    Event.Mouse mouse();

    /** Returns a Event.Key if this is a keyboard event, or null if not. */
    Event.Key key();

    /** Returns a Event.Widget if this is a widget event, or null if not. */
    Event.Widget widget();

    /** Returns a Event.Joystick if this is a joystick event, or null if not. */
    Event.Joystick joystick();

    /**Details for mouse events. Not valid for other events. */
    interface Mouse extends Event {

        /** x location of the mouse  when the event happened. */
        int x();

        /** y location of the mouse  when the event happened. */
        int y();

        /** width of drag motion if available. */
        int w();

        /** height of drag motion if available. */
        int h();

        /** Buttons that changed state. */
        int buttons();

        /** Returns the rotation of the mouse wheel if wheel(- is true.*/
        int rotation();

        /** Returns true if this is a mouse drag event. */
        boolean drag();

        /** Returns true if this is a mouse button down  event. */
        boolean down();

        /** Returns true if this is a mouse button up event. */
        boolean up();

        /** Returns true if this is a mouse click event. */
        boolean click();

        /** Returns true if this is a mouse wheel event. */
        boolean wheel();

        /** Returns true if this is a mouse "in" even, that s, the mouse entered the window or component. */
        boolean in();

        /** Returns true if this is a mouse "out" even, that s, the mouse left the window or component. */
        boolean out();
    }

    /** Possible virtual key symbols */
    enum Sym {
        NONE,
        K_ENTER, K_BACK_SPACE, K_TAB, K_CANCEL, K_CLEAR, K_SHIFT, K_CONTROL,
        K_ALT, K_PAUSE, K_CAPS_LOCK, K_ESCAPE, K_SPACE, K_PAGE_UP, K_PAGE_DOWN,
        K_END, K_HOME, K_LEFT, K_UP, K_RIGHT, K_DOWN, K_COMMA, K_MINUS,
        K_PERIOD, K_SLASH, K_0, K_1, K_2, K_3, K_4, K_5, K_6, K_7, K_8, K_9,
        K_SEMICOLON, K_EQUALS, K_A, K_B, K_C, K_D, K_E, K_F, K_G, K_H, K_I,
        K_J, K_K, K_L, K_M, K_N, K_O, K_P, K_Q, K_R, K_S, K_T, K_U, K_V, K_W,
        K_X, K_Y, K_Z, K_OPEN_BRACKET, K_BACK_SLASH, K_CLOSE_BRACKET,
        K_NUMPAD0, K_NUMPAD1, K_NUMPAD2, K_NUMPAD3, K_NUMPAD4, K_NUMPAD5,
        K_NUMPAD6, K_NUMPAD7, K_NUMPAD8, K_NUMPAD9, K_MULTIPLY,
        K_ADD, K_SEPARATER, K_SEPARATOR, K_SUBTRACT, K_DECIMAL, K_DIVIDE,
        K_DELETE, K_NUM_LOCK, K_SCROLL_LOCK, K_F1, K_F2, K_F3, K_F4, K_F5,
        K_F6, K_F7, K_F8, K_F9, K_F10, K_F11, K_F12, K_F13, K_F14, K_F15,
        K_F16, K_F17, K_F18, K_F19, K_F20, K_F21, K_F22, K_F23, K_F24,
        K_PRINTSCREEN, K_INSERT, K_HELP, K_META, K_BACK_QUOTE, K_QUOTE,
        K_KP_UP, K_KP_DOWN, K_KP_LEFT, K_KP_RIGHT, K_DEAD_GRAVE, K_DEAD_ACUTE,
        K_DEAD_CIRCUMFLEX, K_DEAD_TILDE, K_DEAD_MACRON, K_DEAD_BREVE,
        K_DEAD_ABOVEDOT, K_DEAD_DIAERESIS, K_DEAD_ABOVERING, K_DEAD_DOUBLEACUTE,
        K_DEAD_CARON, K_DEAD_CEDILLA, K_DEAD_OGONEK, K_DEAD_IOTA,
        K_DEAD_VOICED_SOUND, K_DEAD_SEMIVOICED_SOUND, K_AMPERSAND, K_ASTERISK,
        K_QUOTEDBL, K_LESS, K_GREATER, K_BRACELEFT, K_BRACERIGHT, K_AT,
        K_COLON, K_CIRCUMFLEX, K_DOLLAR, K_EURO_SIGN, K_EXCLAMATION_MARK,
        K_INVERTED_EXCLAMATION_MARK, K_LEFT_PARENTHESIS, K_NUMBER_SIGN, K_PLUS,
        K_RIGHT_PARENTHESIS, K_UNDERSCORE, K_WINDOWS, K_CONTEXT_MENU, K_FINAL,
        K_CONVERT, K_NONCONVERT, K_ACCEPT, K_MODECHANGE, K_KANA, K_KANJI,
        K_ALPHANUMERIC, K_KATAKANA, K_HIRAGANA, K_FULL_WIDTH, K_HALF_WIDTH,
        K_ROMAN_CHARACTERS, K_ALL_CANDIDATES, K_PREVIOUS_CANDIDATE,
        K_CODE_INPUT, K_JAPANESE_KATAKANA, K_JAPANESE_HIRAGANA,
        K_JAPANESE_ROMAN, K_KANA_LOCK, K_INPUT_METHOD_ON_OFF, K_CUT, K_COPY,
        K_PASTE, K_UNDO, K_AGAIN, K_FIND, K_PROPS, K_STOP, K_COMPOSE,
        K_ALT_GRAPH, K_BEGIN, K_UNDEFINED,
    }

    /** Allowed key modifier. */
    enum Mod {

        NONE(0), SHIFT(1), CTRL(2), ALT(4), ALTGR(8), SUPER(16), MENU(32);
        int _value;

        Mod(int value) {
            _value = value;
        }
    }

    /** Details for keyboard events. Will be not valid for other events. */
    interface Key extends Event {

        /** Text that this key represents. Only valid if type() is true. */
        char text();

        /** Key symbol of this event. */
        Sym sym();

        /** Key modifyers. */
        Mod mod();

        /** Returns true if this is a key press event. */
        boolean press();

        /** Returns true if this is a key release event. */
        boolean release();

        /** Returns true if this is a key typed event. */
        boolean type();

        /** Returns true if this is a key repetition event. */
        boolean repeat();
    }

    /* Widget or window events. */
    interface Widget extends Event {

        /** Set to true if the widget or window is closing. */
        boolean close();

        /** Set to true if the widget or window has been destroyed. */
        boolean quit();

        /** Returns true if the widget or window has been resized. */
        boolean resize();

        /** Returns true if the widget or window has been moved. */
        boolean move();

        /** New x position of widget. If negative, means "unknown". */
        int x();

        /** New y position of widget. If negative, means "unknown". */
        int y();

        /** New width of widget. If negative, means "unknown". */
        int w();

        /** New height of widget. If negative, means "unknown". */
        int h();
    }

    /** Joystick events. */
    interface Joystick extends Event {

        int stick();

        int axis();

        int value();

        int buttons();

        boolean down();

        boolean up();

        boolean move();
    }
}


