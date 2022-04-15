package fun.listenia.libcmd.exceptions;

/**
 * Thrown when a command is executed by a no-player.
 * And when a functionnality need a player to be executed.
 *
 * Output: console-chat
 */
public class NotPlayerException extends LibExceptions.INTERNAL {
    public NotPlayerException() {
        super("Utilisation d'une fonctionnalité qui requiert d'être exécuté par un joueur.");
    }
}
