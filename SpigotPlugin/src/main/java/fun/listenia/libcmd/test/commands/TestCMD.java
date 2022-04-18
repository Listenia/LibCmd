package fun.listenia.libcmd.test.commands;

import fun.listenia.libcmd.command.Builder;
import fun.listenia.libcmd.command.CommandBukkit;
import fun.listenia.libcmd.handler.BukkitHandler;
import fun.listenia.libcmd.tab.BukkitTab;
import java.util.List;

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

    @Override
    public BukkitTab tab() {
        return new BukkitTab() {
            @Override
            public void execute (List<String> res) throws Exception {
                if (this.is(0, "realTime")) {
                    if (is(1)) {
                        sendMessage("Argument 2 : " + getString(1));
                        res.add(getString(1) + getString(1).hashCode());
                    }
                }
            }
        };
    }
}
