package fun.listenia.libcmd.command;

import fun.listenia.libcmd.exceptions.LibExceptions;
import fun.listenia.libcmd.handler.BungeeHandler;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;

public abstract class CommandBungee extends Command<BungeeHandler> {

    public void register () {
        Builder builder = new Builder();
        this.register(builder);

        net.md_5.bungee.api.plugin.Command cmd = new net.md_5.bungee.api.plugin.Command(builder.getName(), builder.getPermission(), builder.getAliases()) {
            @Override
            public void execute (CommandSender commandSender, String[] args) {
                try {
                    BungeeHandler handler = (BungeeHandler) handle().clone();
                    handler.defineSender(commandSender);
                    handler.defineArgs(args);
                    handler.execute();
                } catch (LibExceptions.PLAYER e) {
                    commandSender.sendMessage(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        ProxyServer.getInstance().getPluginManager().registerCommand(null, cmd);
    }

}
