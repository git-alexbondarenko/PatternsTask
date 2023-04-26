package patterns.task.util;

import patterns.task.domain.Customer;
import patterns.task.domain.Rental;

public abstract class Statement {
    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder resultBuilder = new StringBuilder(getHeader(customer));

        if (!customer.getRentals().isEmpty()) {
            for (Rental rental : customer.getRentals()) {
                double thisAmount = rental.getAmount();
                frequentRenterPoints = rental.getFrequentRenterPoints(frequentRenterPoints);
                resultBuilder.append(getRentalFigures(rental, thisAmount));
                totalAmount += thisAmount;
            }
        }

        resultBuilder.append(getFooter(totalAmount, frequentRenterPoints));
        return resultBuilder.toString();
    }

    protected abstract String getHeader(Customer customer);

    protected abstract String getRentalFigures(Rental rental, double amount);

    protected abstract String getFooter(double totalAmount, int frequentRenterPoints);
}