package fun.listenia.libcmd.command;

import fun.listenia.libcmd.exceptions.LibExceptions;
import fun.listenia.libcmd.handler.BukkitHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public abstract class CommandBukkit extends Command<BukkitHandler> {

    private static CommandMap commandMap;

    static {
        try {
            final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            commandMap = (CommandMap) f.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void register () {
        Builder builder = new Builder();
        this.register(builder);

        org.bukkit.command.Command cmd = new org.bukkit.command.Command(builder.getName()) {
            @Override
            public boolean execute (@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] args) {
                try {
                    BukkitHandler handler = (BukkitHandler) handle().clone();
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
        };
        cmd.setAliases(builder.getAliasesList());
        cmd.setDescription(builder.getDescription());
        cmd.setPermission(builder.getPermission());
        cmd.setPermissionMessage(builder.getPermissionMessage());
        cmd.setUsage(builder.getUsage());

        commandMap.register(builder.getName(), cmd);
    }

}
