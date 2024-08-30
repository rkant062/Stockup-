package Java.DesignPattern.FileSystemPackage;

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

    public void createFile(String type, String name, int size, String... additionalParams) {
        FileFactory<? extends File> factory = factoryRegistry.getFactory(type);
        File file = factory.createFile(name, size, additionalParams);
        cacheManager.addFile(name, file);
        notifier.notifyObservers("Created " + type + ": " + name);
    }

    public void deleteFile(String name) {
        cacheManager.removeFile(name);
        notifier.notifyObservers("Deleted file: " + name);
    }

    public File getFile(String name) {
        return cacheManager.getFile(name);
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
