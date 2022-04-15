package fun.listenia.libcmd.exceptions;

import org.bukkit.ChatColor;

public class ArgNotPlayerException extends LibExceptions.PLAYER {
    public ArgNotPlayerException (final String player) {
        super(ChatColor.RED + "L'argument " + ChatColor.GOLD + player + ChatColor.RED + " n'est pas un joueur (connecté) !");
    }
}
