package fun.listenia.libcmd.handler;

public abstract class Handler implements Cloneable {

    private String[] args;

    public abstract void execute () throws Exception;

    public void defineArgs(String[] args) {
        this.args = args;
    }

    @Override
    public Handler clone () throws CloneNotSupportedException {
        return (Handler) super.clone();
    }

    public String[] getArgs () {
        return args;
    }

    public int args () {
        return args.length;
    }

    public String getString (int index) {
        return args[index];
    }

    public boolean is (int index) {
        return index < args.length;
    }

    public boolean isString (int index) {
        return getString(index) != null;
    }

    public String getString (int index, String def) {
        if (index >= args.length) return def;
        return args[index];
    }

    public boolean is (int index, String value) {
        return is(index) && getString(index).equals(value);
    }

    public boolean is (int index, String... values) {
        if (!is(index)) return false;
        for (String value : values) {
            if (getString(index).equals(value)) return true;
        }
        return false;
    }

    public boolean isInt (int index) {
        return isString(index) && getString(index).matches("\\d+");
    }

    public int getInt (int index) {
        return Integer.parseInt(getString(index));
    }

    public int getInt (int index, int def) {
        if (index >= args.length) return def;
        return Integer.parseInt(getString(index));
    }

    public boolean is (int index, int value) {
        return isInt(index) && getInt(index) == value;
    }

    public boolean isDouble (int index) {
        return isString(index) && getString(index).matches("\\d+\\.\\d+");
    }

    public double getDouble (int index) {
        return Double.parseDouble(getString(index));
    }

    public double getDouble (int index, double def) {
        if (index >= args.length) return def;
        return Double.parseDouble(getString(index));
    }

    public boolean is (int index, double value) {
        return isDouble(index) && getDouble(index) == value;
    }

    public boolean isBoolean (int index) {
        return isString(index) && getString(index).matches("(true|false)");
    }

    public boolean getBoolean (int index) {
        return Boolean.parseBoolean(getString(index));
    }

    public boolean getBoolean (int index, boolean def) {
        if (index >= args.length) return def;
        return Boolean.parseBoolean(getString(index));
    }

    public boolean is (int index, boolean value) {
        return isBoolean(index) && getBoolean(index) == value;
    }



}
