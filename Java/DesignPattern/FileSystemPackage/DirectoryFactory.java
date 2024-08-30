package Java.DesignPattern.FileSystemPackage;

public class DirectoryFactory implements FileFactory<Directory> {
    @Override
    public Directory createFile(String name, String... additionalParams) {
        return new Directory(name);
    }
}