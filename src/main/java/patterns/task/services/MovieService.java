package patterns.task.services;

import patterns.task.dao.MovieDao;
import patterns.task.domain.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieService {
    private Map<String, Movie> movies;
    private final MovieDao movieDao = new MovieDao();
    public MovieService() {
        load();
    }

    public Map<String, Movie> getMovies() {
        return movies;
    }

    public Movie getMovie(String title) {
        return movies.get(title);
    }
    public void addMovie(Movie movie) {
        movies.put(movie.getTitle(), movie);
        /*System.out.println("debug");
        for (Map.Entry<String, Movie> e: getMovies().entrySet()) {
            System.out.println(e.getValue());
        }*/
        save();
    }

    public void updateMovie(Movie updatedMovie) {
        movies.get(updatedMovie.getTitle()).setMovieType(updatedMovie.getMovieType());
        save();
    }

    public void save() {
        movieDao.saveToFile(movies);
    }

    public void load(){
        movies = movieDao.loadFromFile();
    }

    public void findByTitle(String name) {
        for (String key: movies.keySet()) {
            if (key.contains(name)) {
                System.out.println(movies.get(key));
            }
        }
    }
}
