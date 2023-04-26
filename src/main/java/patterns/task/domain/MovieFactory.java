package patterns.task.domain;

import patterns.task.movietypes.MovieType;
import patterns.task.movietypes.MovieTypeFactory;
import patterns.task.services.MovieService;

import java.util.Scanner;

public class MovieFactory {
    private final MovieService movieService = new MovieService();

    public void addMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter title: ");
        String title = scanner.nextLine();
        System.out.println(title);

        System.out.print("enter movie type: ");
        String type = scanner.nextLine().toLowerCase();
        MovieType movieType = MovieTypeFactory.getMovieType(type);

        System.out.print("enter country: ");
        String country = scanner.nextLine();

        System.out.print("enter director: ");
        String director = scanner.nextLine();

        System.out.print("enter description: ");
        String description = scanner.nextLine();

        System.out.print("enter actors: ");
        String[] actors = scanner.nextLine().split(",\\s+");

        Movie newMovie = new Movie.Builder().movieType(movieType).country(country).director(director)
                .description(description).actors(actors).build(title);

        movieService.addMovie(newMovie);
        System.out.println("movie added");
    }
}
