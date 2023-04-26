package patterns.task.util;

import patterns.task.domain.Customer;
import patterns.task.domain.Rental;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlStatement extends Statement {
    @Override
    protected String getHeader(Customer customer) {
        return "<html><h1 style= 'font-family: cursive;'>Rental Record for " + customer.getName() + "</h1>";
    }

    @Override
    protected String getRentalFigures(Rental rental, double amount) {
        return "<p>" + rental.getMovie().getTitle() + "\t" + amount + "</p>";
    }

    @Override
    protected String getFooter(double totalAmount, int frequentRenterPoints) {
        return "<h3>Amount owed is " + totalAmount + "</h3>" + "<h3>You earned " + frequentRenterPoints + " frequent renter points</h3> </html>";
    }

    public static void makeStatement(Customer customer) {
        HtmlStatement htmlStatement = new HtmlStatement();
        String result = htmlStatement.statement(customer);

        try {
            FileWriter fileWriter = new FileWriter("out.html");
            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
