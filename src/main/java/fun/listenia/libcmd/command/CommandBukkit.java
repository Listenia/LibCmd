package fun.listenia.libcmd.command;

import fun.listenia.libcmd.command.abs.AbsBukkit;
import fun.listenia.libcmd.handler.BukkitHandler;
import fun.listenia.libcmd.tab.BukkitTab;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import java.lang.reflect.Field;

public abstract class CommandBukkit extends Command<BukkitHandler, BukkitTab> {
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

        AbsBukkit absBukkit = new AbsBukkit(this, builder);
        commandMap.register(builder.getName(), absBukkit);
    }

    @Override
    public BukkitTab tab () {
        return null;
    }
}
