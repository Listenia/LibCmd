package fun.listenia.libcmd.command;

import fun.listenia.libcmd.handler.Handler;

public abstract class Command<T extends Handler> {

    public abstract void register (Builder builder);

    public abstract T handle ();

}