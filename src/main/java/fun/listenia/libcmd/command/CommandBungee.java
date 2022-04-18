package fun.listenia.libcmd.command;

import fun.listenia.libcmd.command.abs.AbsBungee;
import fun.listenia.libcmd.handler.BungeeHandler;
import fun.listenia.libcmd.tab.BungeeTab;
import net.md_5.bungee.api.ProxyServer;

public abstract class CommandBungee extends Command<BungeeHandler, BungeeTab> {
    public void register () {
        Builder builder = new Builder();
        this.register(builder);

        AbsBungee absBungee = new AbsBungee(this, builder);
        ProxyServer.getInstance().getPluginManager().registerCommand(null, absBungee);
    }

    @Override
    public BungeeTab tab () {
        return null;
    }
}
