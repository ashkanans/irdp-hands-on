package protocols.utils;

public class Debug {

    private final static boolean debugOn = false;

    public static void print(String message) {
        if (debugOn)
            System.err.println(message);
    }
}
