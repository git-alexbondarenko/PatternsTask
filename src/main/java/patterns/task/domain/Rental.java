package patterns.task.domain;

import patterns.task.movietypes.NewRelease;

import java.io.Serializable;

public class Rental implements Serializable {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        return getMovie().getMovieType().getAmount(daysRented);
    }

    public int getFrequentRenterPoints(int frequentRenterPoints) {
        frequentRenterPoints++;
        if ((getMovie().getMovieType().getClass() == NewRelease.class) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    @Override
    public String toString() {
        return "{" +
                "movie=" + movie.getTitle() +
                ", daysRented=" + daysRented +
                "}";
    }
}
