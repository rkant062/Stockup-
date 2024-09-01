package Java.DesignPattern.FileSystemPackage;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ravik
 */
public class TextFile extends File {
    private String content;
    private int size;

    public TextFile(String name, String content) {
        super(name);
        this.content = content;
        this.size = this.content.length()*2*1024;
    }

    public void open() {
        System.out.println("Opening text file: " + name);
    }


    public void close() {
        System.out.println("Closing text file: " + name);
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }
}