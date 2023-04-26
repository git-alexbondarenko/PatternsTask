package patterns.task.movietypes;

import java.io.Serializable;

public interface MovieType extends Serializable {

    String getName();
    double getAmount(int daysRented);
}
