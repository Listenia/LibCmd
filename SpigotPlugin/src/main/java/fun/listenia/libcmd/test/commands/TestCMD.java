package fun.listenia.libcmd.test.commands;

import fun.listenia.libcmd.command.Builder;
import fun.listenia.libcmd.command.CommandBukkit;
import fun.listenia.libcmd.handler.BukkitHandler;

public class TestCMD extends CommandBukkit {
    @Override
    public void register (Builder builder) {
        builder.setName("test");
        builder.setDescription("Ceci est une description");
        builder.setAliases("alternative");
    }

    @Override
    public BukkitHandler handle() {
        return new BukkitHandler() {
            @Override
            public void execute() throws Exception {
                if (args() == 0) {
                    sendMessage("Vous n'avez pas spécifié d'argument");
                    if (isPlayer()) {
                        sendMessage("Vous êtes un joueur");
                    } else {
                        sendMessage("Vous n'êtes pas un joueur");
                    }
                } else {
                    sendMessage("Vous avez spécifié " + args() + " argument(s)");
                    if (this.is(0, "requirePlayer")) {
                        if (requirePlayer()) {
                            sendMessage("Vous êtes un joueur");
                        }
                    }
                }
            }
        };
    }
}
