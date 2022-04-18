package fun.listenia.libcmd.command.abs;

import fun.listenia.libcmd.command.Builder;
import fun.listenia.libcmd.command.CommandBungee;
import fun.listenia.libcmd.exceptions.LibExceptions;
import fun.listenia.libcmd.handler.BungeeHandler;
import fun.listenia.libcmd.tab.BungeeTab;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;

import java.util.ArrayList;
import java.util.List;

public class AbsBungee extends Command implements Listener {
    private final CommandBungee bungee;

    public AbsBungee (CommandBungee bungee, Builder builder) {
        super(builder.getName(), builder.getPermission(), builder.getAliases());
        this.bungee = bungee;
    }

    @Override
    public void execute (CommandSender commandSender, String[] args) {
        try {
            BungeeHandler handler = (BungeeHandler) bungee.handle().clone();
            handler.defineSender(commandSender);
            handler.defineArgs(args);
            handler.execute();
        } catch (LibExceptions.PLAYER e) {
            commandSender.sendMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // from Bungee
    public final Iterable<String> onTabComplete (CommandSender sender, String[] args) {
        try {
            if (bungee.tab() == null)
                return fun.listenia.libcmd.command.Command.EMPTY;
            BungeeTab tab = (BungeeTab) bungee.tab().clone();
            tab.defineSender(sender);
            tab.defineArgs(args);

            final List<String> list = new ArrayList<>();
            tab.execute(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fun.listenia.libcmd.command.Command.EMPTY;
    }

    // Overridable method
    public List<String> tabComplete (final CommandSender sender, final String[] args) {
        return (List<String>) onTabComplete(sender, args);
    }

}
