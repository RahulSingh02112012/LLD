package LowLevelDesigns.CompositePattern.FileSystem;

public class File implements FileSystem{
    String fileName;

    public File (String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void ls() {
        System.out.printf("This is the file: %s%n",fileName);
    }
}
