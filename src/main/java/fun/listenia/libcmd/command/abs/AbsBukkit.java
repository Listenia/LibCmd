package fun.listenia.libcmd.command.abs;

import fun.listenia.libcmd.command.Builder;
import fun.listenia.libcmd.command.CommandBukkit;
import fun.listenia.libcmd.exceptions.LibExceptions;
import fun.listenia.libcmd.handler.BukkitHandler;
import fun.listenia.libcmd.tab.BukkitTab;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AbsBukkit extends Command {
    private final CommandBukkit bukkit;

    public AbsBukkit(CommandBukkit bukkit, Builder builder) {
        super(builder.getName());
        this.bukkit = bukkit;
        this.setAliases(builder.getAliasesList());
        this.setDescription(builder.getDescription());
        this.setPermission(builder.getPermission());
        this.setPermissionMessage(builder.getPermissionMessage());
        this.setUsage(builder.getUsage());
    }

    @Override
    public boolean execute (@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] args) {
        try {
            BukkitHandler handler = (BukkitHandler) bukkit.handle().clone();
            handler.defineSender(commandSender);
            handler.defineArgs(args);
            handler.execute();
        } catch (LibExceptions.PLAYER e) {
            commandSender.sendMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @NotNull
    @Override
    public List<String> tabComplete (@NotNull final CommandSender sender, @NotNull final String alias, @NotNull final String[] args) throws IllegalArgumentException {
        try {
            if (bukkit.tab() == null)
                return fun.listenia.libcmd.command.Command.EMPTY;
            BukkitTab tab = (BukkitTab) bukkit.tab().clone();
            tab.defineSender(sender);
            tab.defineArgs(args);

            final List<String> list = new ArrayList<>();
            tab.execute(list);
            System.out.println(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fun.listenia.libcmd.command.Command.EMPTY;
    }

    // from Bukkit
    @NotNull
    @Override
    public final List<String> tabComplete (@NotNull final CommandSender sender, @NotNull final String alias, @NotNull final String[] args, @Nullable final Location location) throws IllegalArgumentException {
        return tabComplete(sender, alias, args);
    }

}
