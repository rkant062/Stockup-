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

    public TextFile(String name, int size, String content) {
        super(name, size);
        this.content = content;
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
}