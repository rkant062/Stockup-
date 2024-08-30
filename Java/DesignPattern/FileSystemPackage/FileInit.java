package Java.DesignPattern.FileSystemPackage;


public class FileInit {

    public static void main(String[] args) {
        // Initialize factories
        FactoryInitializer.initializeFactories();

        // Initialize FileSystem
        FileSystem fs = new FileSystem();

        // Create a text file
        fs.createFile("text", "document.txt", 50, "Hello, World! Bam");

        // Create a directory
        fs.createFile("directory", "myFolder", 0);


        // Compress the text file
        //fs.compressFile("document.txt");

        // Set a cache eviction strategy
        //fs.setCacheEvictionStrategy(new LRUCacheStrategy());

        // Access and interact with files
        File file = fs.getFile("document.txt");
        if (file instanceof TextFile) {
            TextFile textFile = (TextFile) file;
            textFile.open();
            System.out.println("Content: " + textFile.getContent());
            System.out.println("Content: " + textFile.getSize());
            textFile.close();
        }

        // Delete a file
        fs.deleteFile("document.txt");
    }
    
}
