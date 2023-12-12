package CompositePattern.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String directoryName;
    List<FileSystem> listOfFiles;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        listOfFiles = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        this.listOfFiles.add(fileSystem);
    }


    @Override
    public void ls() {
        System.out.printf("Directory Name is: %s%n",this.directoryName);
        for(FileSystem f : this.listOfFiles) {
            f.ls();
        }
    }
}
