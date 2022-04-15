package fun.listenia.libcmd.test;

import fun.listenia.libcmd.test.commands.TestCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Test plugin LibCMD is started !");

        new TestCMD().register();

    }

}
