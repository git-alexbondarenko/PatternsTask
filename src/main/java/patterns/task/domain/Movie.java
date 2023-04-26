package patterns.task.domain;

import patterns.task.movietypes.MovieType;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable {
    private final String title;
    private String country;
    private String director;
    private String description;
    private String[] actors;
    private MovieType movieType;

    private Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public String[] getActors() {
        return actors;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "{" + title + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", actors=" + Arrays.toString(actors) +
                ", movieType=" + movieType +
                '}';
    }

    public static class Builder {
        private String country;
        private String director;
        private String description;
        private String[] actors;
        private MovieType movieType;

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder director(String director) {
            this.director = director;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder actors(String[] actors) {
            this.actors = actors;
            return this;
        }

        public Builder movieType(MovieType movieType) {
            this.movieType = movieType;
            return this;
        }


        public Movie build(String title) {
            Movie newMovie = new Movie(title);
            newMovie.movieType = movieType;
            newMovie.country = country;
            newMovie.director = director;
            newMovie.description = description;
            newMovie.actors = actors;

            return newMovie;
        }

    }
}