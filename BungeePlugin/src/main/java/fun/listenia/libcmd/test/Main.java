package fun.listenia.libcmd.test;

import fun.listenia.libcmd.test.commands.TestCMD;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    @Override
    public void onEnable() {
        getLogger().info("Test plugin LibCMD is started !");
        new TestCMD().register();
    }

}
