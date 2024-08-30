package Java.DesignPattern.FileSystemPackage;

public interface FileSystemObserver {
    void update(String message, Status status);
}