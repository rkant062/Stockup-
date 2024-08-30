package Java.DesignPattern.FileSystemPackage;

// FactoryRegistry.java
import java.util.HashMap;
import java.util.Map;

public class FactoryRegistry {
    private static FactoryRegistry instance;
    private Map<String, FileFactory<? extends File>> registry = new HashMap<>();

    private FactoryRegistry() {}

    public static synchronized FactoryRegistry getInstance() {
        if (instance == null) {
            instance = new FactoryRegistry();
        }
        return instance;
    }

    public void registerFactory(String fileType, FileFactory<? extends File> factory) {
        registry.put(fileType.toLowerCase(), factory);
    }

    public FileFactory<? extends File> getFactory(String fileType) {
        FileFactory<? extends File> factory = registry.get(fileType.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("No factory registered for file type: " + fileType);
        }
        return factory;
    }
}
