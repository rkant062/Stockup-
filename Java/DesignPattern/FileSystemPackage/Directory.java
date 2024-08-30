package Java.DesignPattern.FileSystemPackage;
import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    private List<File> children = new ArrayList<>();

    public Directory(String name) {
        super(name, 0);
    }

    public void addFile(File file) {
        children.add(file);
    }

    public List<File> getChildren() {
        return children;
    }

    @Override
    public void open() {
        System.out.println("Opening directory: " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing directory: " + name);
    }
}