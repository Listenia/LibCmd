package fun.listenia.libcmd.exceptions;

import org.bukkit.ChatColor;

public class ArgNotOfflinePlayerException extends LibExceptions.PLAYER {
    public ArgNotOfflinePlayerException (String player) {
        super(ChatColor.RED + "Player " + ChatColor.GOLD + player + ChatColor.RED + " not found.");
    }
}
