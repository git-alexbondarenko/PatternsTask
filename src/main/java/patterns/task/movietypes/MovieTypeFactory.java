package patterns.task.movietypes;


import java.util.*;

public class MovieTypeFactory {
    private static Map<String, MovieType> movieTypes = new HashMap<>();

    public static MovieType getMovieType(String name) {
        MovieType movieType = movieTypes.get(name);

        if (movieType == null) {
            switch (name) {
                case "children" -> movieType = new Children();
                case "newrelease" -> movieType = new NewRelease();
                case "regular" -> movieType = new Regular();
                case "drama" -> movieType = new Drama();
                default ->  {
                    System.out.println("no such movie type, set regular");
                    movieType = new Regular();
                }
            }
            movieTypes.put(name, movieType);
        }
        return movieType;
    }
}
