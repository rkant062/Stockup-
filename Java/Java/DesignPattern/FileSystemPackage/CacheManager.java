package Java.DesignPattern.FileSystemPackage;

import java.util.*;

public class CacheManager {
    private static CacheManager instance;
    private Map<String, File> cache = new HashMap<>();

    private CacheManager() {}

    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public File getFile(String path) {
        return cache.get(path);
    }

    public void addFile(String path, File file) {
        cache.put(path, file);
    }

    public void removeFile(String path) {
        cache.remove(path);
    }
}
