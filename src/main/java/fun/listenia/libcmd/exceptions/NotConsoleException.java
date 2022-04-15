package fun.listenia.libcmd.exceptions;

/**
 * Thrown when a command is executed by a no-console.
 * And when a functionnality need a player to be executed.
 *
 * Output: player-chat
 */
public class NotConsoleException extends LibExceptions.INTERNAL {
    public NotConsoleException() {
        super("Utilisation d'une fonctionnalité qui requiert d'être exécuté par la console.");
    }
}
