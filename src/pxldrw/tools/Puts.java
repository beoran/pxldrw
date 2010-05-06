
package pxldrw.tools;

/**
 * Static import that contains utilites for puts, printf, sprintf
 * @author bjmey
 */
public class Puts {
    public static void puts(Object... args) {
        for (Object arg : args) {
            println(arg.toString());
        }
    }

    public static void printf(String format, Object... args) {
        System.out.format(format, args);
    }

    public static void println(String line) {
        System.out.println(line);
    }
    


}
