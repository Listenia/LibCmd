package fun.listenia.libcmd.command;

import fun.listenia.libcmd.handler.Handler;
import fun.listenia.libcmd.tab.Tab;

import java.util.List;

public abstract class Command<T extends Handler, U extends Tab> {

    public static final List<String> EMPTY = List.of();

    public abstract void register (Builder builder);

    public abstract T handle ();

    public abstract U tab ();

}