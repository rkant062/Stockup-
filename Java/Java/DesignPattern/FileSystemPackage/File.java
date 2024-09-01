package Java.DesignPattern.FileSystemPackage;

import java.time.LocalDateTime;

public abstract class File {
    protected String name;
    protected LocalDateTime createdTime;
    protected LocalDateTime modifiedTime;
    protected LocalDateTime accessedTime;

    public File(String name) {
        this.name = name;
        this.createdTime = LocalDateTime.now();
        this.modifiedTime = this.createdTime;
        this.accessedTime = this.createdTime;
    }

    public abstract void open();
    public abstract void close();

    public String getName() {
        return name;
    }


    public void updateAccessedTime() {
        this.accessedTime = LocalDateTime.now();
    }

    public void updateModifiedTime() {
        this.modifiedTime = LocalDateTime.now();
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public LocalDateTime getAccessedTime() {
        return accessedTime;
    }

    protected abstract int getSize();
}