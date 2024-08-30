package Java.DesignPattern.FileSystemPackage;

public class TextFileFactory implements FileFactory<TextFile> {
    @Override
    public TextFile createFile(String name, String... additionalParams) {
        String content = additionalParams.length > 0 ? additionalParams[0] : "";
        return new TextFile(name, content);
    }
}
