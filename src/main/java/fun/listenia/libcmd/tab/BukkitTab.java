package fun.listenia.libcmd.tab;

import fun.listenia.libcmd.exceptions.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class BukkitTab extends Tab {

    private CommandSender sender;

    public void defineSender (CommandSender sender) {
        this.sender = sender;
    }

    public CommandSender getSender () {
        return sender;
    }

    public void sendMessage (String message) {
        sender.sendMessage(message);
    }

    public void sendMessage (String... messages) {
        for (String message : messages) {
            sender.sendMessage(message);
        }
    }

    public boolean isPlayer () {
        return sender instanceof org.bukkit.entity.Player;
    }

    public org.bukkit.entity.Player getPlayer () throws NotPlayerException {
        if (isPlayer())
            return (org.bukkit.entity.Player) sender;
        throw new NotPlayerException();
    }

    public boolean isConsole () {
        return sender instanceof org.bukkit.command.ConsoleCommandSender;
    }

    public org.bukkit.command.ConsoleCommandSender getConsole () throws NotConsoleException {
        if (isConsole())
            return (org.bukkit.command.ConsoleCommandSender) sender;
        throw new NotConsoleException();
    }

    public boolean hasPermission (String permission) {
        return sender.hasPermission(permission);
    }

    public boolean hasPermission (String... permissions) {
        for (String permission : permissions) {
            if (!hasPermission(permission)) {
                return false;
            }
        }
        return true;
    }

    public World getWorld () throws NotPlayerException {
        return getPlayer().getWorld();
    }

    public Location getLocation () throws NotPlayerException {
        return getPlayer().getLocation();
    }

    public double getX () throws NotPlayerException {
        return getLocation().getX();
    }

    public double getY () throws NotPlayerException {
        return getLocation().getY();
    }

    public double getZ () throws NotPlayerException {
        return getLocation().getZ();
    }

    public float getYaw () throws NotPlayerException {
        return getLocation().getYaw();
    }

    public float getPitch () throws NotPlayerException {
        return getLocation().getPitch();
    }

    public void teleport (Location location) throws NotPlayerException {
        getPlayer().teleport(location);
    }

    public void teleport (Entity entity) throws NotPlayerException {
        getPlayer().teleport(entity);
    }




    public boolean isPlayer (int index) {
        String arg = getString(index);
        if (arg == null)
            return false;
        return Bukkit.getPlayer(arg) != null;
    }

    public Player getPlayer (int index) throws ArgNotPlayerException {
        String arg = getString(index);
        if (arg == null)
            return null;
        Player player = Bukkit.getPlayer(arg);
        if (player != null)
            return player;
        throw new ArgNotPlayerException(arg);
    }

    public boolean is (int index, @NotNull Player value) {
        return is(index) && value.equals(Bukkit.getPlayer(getString(index)));
    }

    public boolean isOfflinePlayer (int index) {
        String arg = getString(index);
        if (arg == null)
            return false;
        return Bukkit.getOfflinePlayer(arg) != null;
    }

    public OfflinePlayer getOfflinePlayer (int index) throws ArgNotOfflinePlayerException {
        String arg = getString(index);
        if (arg == null)
            return null;
        OfflinePlayer player = Bukkit.getOfflinePlayer(arg);
        if (player != null)
            return player;
        throw new ArgNotOfflinePlayerException(arg);
    }

    public boolean is (int index, @NotNull OfflinePlayer value) {
        return is(index) && value.equals(Bukkit.getOfflinePlayer(getString(index)));
    }
}
