package fun.listenia.libcmd.exceptions;

public class LibExceptions {
    public static class PLAYER extends Exception {
        public PLAYER(String message) {
            super(message);
        }
    }
    public static class INTERNAL extends Exception {
        public INTERNAL(String message) {
            super(message);
        }
    }
}
