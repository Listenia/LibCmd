package fun.listenia.libcmd.exceptions;

import org.bukkit.ChatColor;

/**
 * Thrown when a command is executed by a non-console.
 * And requireConsole() is called.
 *
 * Output: player-chat
 */
public class RequiredConsoleException extends LibExceptions.PLAYER {
    public RequiredConsoleException() {
        super(ChatColor.RED + "Cette commande ne peut être utilisée que par la console.");
    }
}


