package Java.DesignPattern.FileSystemPackage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerObserver implements FileSystemObserver {
    @Override
    public void update(String message, Status status) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // Format the date and time in a readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = "[" +  now.format(formatter) + "]";

        // Log the message with the current time and status
        System.out.println(formattedDateTime + " Logger: " + status + " " + message);
    }
}