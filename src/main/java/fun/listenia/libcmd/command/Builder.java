package fun.listenia.libcmd.command;

import java.util.List;

public class Builder {

    private String name;
    private String[] aliases;

    private String description;
    private String usage;
    private String permission;
    private String permissionMessage;

    public String getName () {
        return name;
    }

    public Builder setName (String name) {
        this.name = name;
        return this;
    }

    public String[] getAliases () {
        return aliases;
    }

    public List<String> getAliasesList () {
        return List.of(aliases);
    }

    public Builder setAliases (String... aliases) {
        this.aliases = aliases;
        return this;
    }

    public Builder setAliases (List<String> aliases) {
        this.aliases = aliases.toArray(new String[0]);
        return this;
    }

    public String getDescription () {
        return description;
    }

    public Builder setDescription (String description) {
        this.description = description;
        return this;
    }

    public String getUsage () {
        return usage;
    }

    public Builder setUsage (String usage) {
        this.usage = usage;
        return this;
    }

    public String getPermission () {
        return permission;
    }

    public Builder setPermission (String permission) {
        this.permission = permission;
        return this;
    }

    public String getPermissionMessage () {
        return permissionMessage;
    }

    public Builder setPermissionMessage (String permissionMessage) {
        this.permissionMessage = permissionMessage;
        return this;
    }

}
