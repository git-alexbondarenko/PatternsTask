package patterns.task.movietypes;

import patterns.task.movietypes.MovieType;

public class Drama implements MovieType {
    @Override
    public String getName() {
        return "drama";
    }

    @Override
    public double getAmount(int daysRented) {
        double res = 4;
        if (daysRented > 1)
            res += (daysRented - 1) * 2;
        return res;
    }
}
