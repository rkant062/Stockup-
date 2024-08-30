package Java.DesignPattern.FileSystemPackage;
public abstract class File {
    protected String name;
    protected int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public abstract void open();
    public abstract void close();

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}