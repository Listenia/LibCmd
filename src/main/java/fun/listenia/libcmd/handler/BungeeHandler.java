package fun.listenia.libcmd.handler;

import fun.listenia.libcmd.exceptions.ArgNotPlayerException;
import fun.listenia.libcmd.exceptions.RequiredConsoleException;
import fun.listenia.libcmd.exceptions.RequiredPlayerException;
import fun.listenia.libcmd.exceptions.NotPlayerException;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

public abstract class BungeeHandler extends Handler {

    private CommandSender sender;

    public void defineSender (CommandSender sender) {
        this.sender = sender;
    }

    public CommandSender getSender () {
        return sender;
    }

    public void sendMessage (String message) {
        sender.sendMessage(message);
    }

    public void sendMessage (String... messages) {
        for (String message : messages) {
            sender.sendMessage(message);
        }
    }

    public boolean requirePlayer () throws RequiredPlayerException {
        if (sender instanceof ProxiedPlayer)
            return true;
        throw new RequiredPlayerException();
    }

    public boolean isPlayer () {
        return sender instanceof ProxiedPlayer;
    }

    public ProxiedPlayer getPlayer () throws NotPlayerException {
        if (isPlayer())
            return (ProxiedPlayer) sender;
        throw new NotPlayerException();
    }

    public boolean requireConsole () throws RequiredConsoleException {
        if (!(sender instanceof ProxiedPlayer))
            return true;
        throw new RequiredConsoleException();
    }

    public boolean isConsole () {
        return !(sender instanceof ProxiedPlayer);
    }

    public boolean hasPermission (String permission) {
        return sender.hasPermission(permission);
    }

    public boolean hasPermission (String... permissions) {
        for (String permission : permissions) {
            if (!hasPermission(permission)) {
                return false;
            }
        }
        return true;
    }


    public boolean isPlayer (int index) {
        String arg = getArg(index);
        if (arg == null)
            return false;
        return ProxyServer.getInstance().getPlayer(arg) != null;
    }

    public ProxiedPlayer getPlayer (int index) throws ArgNotPlayerException {
        String arg = getArg(index);
        if (arg == null)
            return null;
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(arg);
        if (player != null)
            return player;
        throw new ArgNotPlayerException(arg);
    }

    public boolean is (int index, @NotNull ProxiedPlayer value) {
        return is(index) && value.equals(ProxyServer.getInstance().getPlayer(getArg(index)));
    }


}
