package fun.listenia.libcmd.exceptions;

import org.bukkit.ChatColor;

/**
 * Thrown when a command is executed by a non-player.
 * And requirePlayer() is called.
 *
 * Output: console-chat
 */
public class RequiredPlayerException extends LibExceptions.PLAYER {
    public RequiredPlayerException() {
        super(ChatColor.RED + "Vous devez être un joueur pour utiliser cette commande.");
    }
}
