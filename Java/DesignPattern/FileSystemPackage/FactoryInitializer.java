package Java.DesignPattern.FileSystemPackage;

public class FactoryInitializer {
    public static void initializeFactories() {
        FactoryRegistry registry = FactoryRegistry.getInstance();
        registry.registerFactory("text", new TextFileFactory());
        registry.registerFactory("directory", new DirectoryFactory());
        // Register additional factories here as needed
    }
}