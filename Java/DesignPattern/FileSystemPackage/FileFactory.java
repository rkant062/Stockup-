package Java.DesignPattern.FileSystemPackage;

// FileFactory.java
public interface FileFactory<T extends File> {
    T createFile(String name, int size, String... additionalParams);
}
