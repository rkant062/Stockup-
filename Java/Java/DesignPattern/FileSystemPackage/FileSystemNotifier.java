package Java.DesignPattern.FileSystemPackage;

import java.util.ArrayList;
import java.util.List;

public class FileSystemNotifier {
    private List<FileSystemObserver> observers = new ArrayList<>();

    public void addObserver(FileSystemObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(FileSystemObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message, Status status, long time ) {
        for (FileSystemObserver observer : observers) {
            observer.update(message, status, time);
        }
    }
}

