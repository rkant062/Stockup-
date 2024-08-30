package Java.DesignPattern.FileSystemPackage;


public class FileInit {

    public static void main(String[] args) {
        // Initialize factories
        FactoryInitializer.initializeFactories();

        // Initialize FileSystem
        FileSystem fs = new FileSystem();

        // Create a text file
       // fs.createFile("text", "document.txt", 50, "Hello, World! Bam");

        // Create a directory
       // File createTimeDir =   
        //System.out.println("Create dir time: " + createTimeDir + " ms");


// Create a file and log the time taken
        //File createTime = fs.createFile("text", "documentx.txt", 50, "Hello, World Lorem Ipsum Hello, World Lorem IpsumHello, World Lorem IpsumHello, World Lorem IpsumHello, World Lorem IpsumHello, World Lorem Ipsum!");
        //System.out.println("Create time: " + createTime + " ms");

        // Move the file and log the time taken
       // boolean ismove = fs.moveFile("documentx.txt", "newDocument.txt");
        //System.out.println("Move time: " + moveTime + " ms");

        // Delete the file and log the time taken
        //boolean isdelete = fs.deleteFile("newDocument.txt");
        

        File dir = fs.createFile("directory", "myFolder", "Hello, World! Bam");

        // Create some files
        File file1 = fs.createFile("text", "document1.txt",  "Hello, World! Bam");
        File file2 = fs.createFile("text", "document2.txt",  "Hello, World! Bam");

        // Add files to the directory
        fs.addFileToDirectory("myFolder", file1);
        fs.addFileToDirectory("myFolder", file2);

        // List the contents of the directory
        fs.listDirectoryContents("myFolder");
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
