package patterns.task.util;


import patterns.task.domain.Customer;
import patterns.task.domain.Rental;

public class ConsoleStatement extends Statement{
    @Override
    protected String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    protected String getRentalFigures(Rental rental, double amount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + amount + "\n";
    }

    @Override
    protected String getFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points";
    }

    public static void makeStatement(Customer customer) {
        ConsoleStatement consoleStatement = new ConsoleStatement();
        System.out.println(consoleStatement.statement(customer));
    }
}
