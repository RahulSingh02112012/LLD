package CompositePattern.FileSystem;

public class Main {
    public static void main(String[] args) {
        Directory mainDirectory = new Directory("MainFolder");
        mainDirectory.add(new File("OneMovie"));

        Directory comedyMovieDirectory = new Directory("ComedyMovieFolder");
        comedyMovieDirectory.add(new File("OneComedyMovie"));
        mainDirectory.add(comedyMovieDirectory);

        mainDirectory.ls();
    }
}
