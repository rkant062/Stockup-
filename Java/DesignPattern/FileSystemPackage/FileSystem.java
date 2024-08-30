package Java.DesignPattern.FileSystemPackage;

import java.time.Duration;
import java.time.Instant;

// FileSystem.java
public class FileSystem {
    private CacheManager cacheManager;
    private FileSystemNotifier notifier;
    private FactoryRegistry factoryRegistry;


    public FileSystem() {
        this.cacheManager = CacheManager.getInstance();
        this.notifier = new FileSystemNotifier();
        this.notifier.addObserver(new LoggerObserver());
        this.factoryRegistry = FactoryRegistry.getInstance();
    }

    public File getFile(String name) {
        return cacheManager.getFile(name);
    }


      public File createFile(String type, String name, String... additionalParams) {
        Instant start = Instant.now(); // Start timing
        FileFactory<? extends File> factory = FactoryRegistry.getInstance().getFactory(type);
        File file = factory.createFile(name, additionalParams);
        cacheManager.addFile(name, file);
        Instant end = Instant.now(); // End timing

        long timeElapsed = Duration.between(start, end).toMillis(); // Calculate time taken
        notifier.notifyObservers("Created " + type + ": " + name + " " + file.getSize(), Status.INFO, timeElapsed);
        return file;
    }

    public boolean deleteFile(String name) {
        Instant start = Instant.now(); // Start timing
        File file = cacheManager.getFile(name);
        if (file != null) {
            file.updateModifiedTime();
            cacheManager.removeFile(name);
            Instant end = Instant.now(); // End timing

            long timeElapsed = Duration.between(start, end).toMillis(); // Calculate time taken
            notifier.notifyObservers("Deleted file: " + name, Status.INFO, timeElapsed);
            return true;
        }
        return false;
    }

    public boolean moveFile(String source, String destination) {
        Instant start = Instant.now(); // Start timing
        File file = cacheManager.getFile(source);
        if (file != null) {
            file.updateModifiedTime();
            cacheManager.removeFile(source);
            cacheManager.addFile(destination, file);
            Instant end = Instant.now(); // End timing

            long timeElapsed = Duration.between(start, end).toMillis(); // Calculate time taken
            notifier.notifyObservers("Moved file: " + source + " to " + destination, Status.INFO, timeElapsed);
            return true;
        }
        return false;
    }

    public void createDirectory(String name) {
        Directory dir = new Directory(name);
        cacheManager.addFile(name, dir);
        notifier.notifyObservers("Created directory: " + name, Status.INFO, 0);
    }

    public void addFileToDirectory(String directoryName, File file) {
        Directory directory = (Directory) cacheManager.getFile(directoryName);
        if (directory != null) {
            directory.addFile(file);
            notifier.notifyObservers("Added file: " + file.getName() + " to directory: " + directoryName, Status.INFO, 0);
        }
    }

    public void listDirectoryContents(String directoryName) {
        Instant start = Instant.now(); 
        Directory directory = (Directory) cacheManager.getFile(directoryName);
        if (directory != null) {
            System.out.println("Listing contents of directory: " + directoryName);
            for (File file : directory.getChildren()) {
                System.out.println("- " + file.getName() + " (size: " + file.getSize() + " bytes)");
            }
            Instant end = Instant.now();
            long timeElapsed = Duration.between(start, end).toMillis(); 
            notifier.notifyObservers("Listing directory: " + directoryName, Status.INFO, timeElapsed);
        } else {
            System.out.println("Directory not found: " + directoryName);
        }
           

    }
    // public void compressFile(String name) {
    //     File file = getFile(name);
    //     if (file != null) {
    //         File compressedFile = new CompressedFileDecorator(file);
    //         cacheManager.addFile(name, compressedFile);
    //         notifier.notifyObservers("Compressed file: " + name);
    //     }
    // }

    // public void setCacheEvictionStrategy(CacheStrategy strategy) {
    //     CacheManagerWithStrategy cacheManagerWithStrategy = new CacheManagerWithStrategy();
    //     cacheManagerWithStrategy.setStrategy(strategy);
    //     cacheManagerWithStrategy.evict();
    // }
}
