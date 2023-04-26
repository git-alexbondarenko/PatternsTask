package patterns.task.movietypes;

import patterns.task.movietypes.MovieType;

public class NewRelease implements MovieType {
    @Override
    public String getName() {
        return "newrelease";
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
