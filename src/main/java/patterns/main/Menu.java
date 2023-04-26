package patterns.main;

import patterns.task.domain.Customer;
import patterns.task.domain.Movie;
import patterns.task.domain.MovieFactory;
import patterns.task.movietypes.MovieTypeFactory;
import patterns.task.movietypes.Children;
import patterns.task.services.CustomerService;
import patterns.task.services.MovieService;
import patterns.task.util.ConsoleStatement;
import patterns.task.util.HtmlStatement;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        MovieService movieService = new MovieService();
        CustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        MovieFactory movieFactory = new MovieFactory();
        String action;

        System.out.println(new Children().getClass().getName());
        showLegend();
        while (true) {
            System.out.print("\nenter action (show legend - 0): ");
            action = scanner.nextLine();
            switch (action) {
                case "1" -> {
                    for (Map.Entry<String, Customer> e : customerService.getCustomers().entrySet()) {
                        System.out.println(e.getValue());
                    }
                }
                case "2" -> {
                    // by some reason, this output doesn't display last movies added until restart
                    // same code works correctly in MovieService.addMovie()

                    for (Map.Entry<String, Movie> e: movieService.getMovies().entrySet()) {
                        System.out.println(e.getValue());
                    }
                }
                case "3" -> {
                    System.out.print("enter name: ");
                    customerService.addCustomer(scanner.nextLine());
                }

                case "4" -> movieFactory.addMovie();

                case "5" -> {
                    System.out.print("enter name: ");
                    customerService.findByName(scanner.nextLine());
                }

                case "6" -> {
                    System.out.print("enter title: ");
                    movieService.findByTitle(scanner.nextLine());
                }

                case "7" -> {
                    System.out.print("enter customer name: ");
                    Customer customer = customerService.getByName(scanner.nextLine());
                    if (customer == null) {
                        System.out.println("no such customer");
                        break;
                    }
                    System.out.print("enter movie name: ");
                    Movie movie = movieService.getMovie(scanner.nextLine());
                    if (movie == null) {
                        System.out.println("no such movie");
                        break;
                    }
                    System.out.print("enter days to rent: ");
                    int days = Integer.parseInt(scanner.nextLine());
                    customer.addRental(movie, days);
                    customerService.updateCustomer(customer);
                }

                case "8" -> {
                    System.out.print("enter customer name: ");
                    Customer customer = customerService.getByName(scanner.nextLine());
                    ConsoleStatement.makeStatement(customer);
                }

                case "9" -> {
                    System.out.print("enter customer name: ");
                    Customer customer = customerService.getByName(scanner.nextLine());
                    if (customer == null) {
                        System.out.println("no such customer");
                        break;
                    }
                    HtmlStatement.makeStatement(customer);
                }

                case "10" -> {
                    System.out.print("enter movie name: ");
                    Movie movie = movieService.getMovie(scanner.nextLine());
                    if (movie == null) {
                        System.out.println("no such movie");
                        break;
                    }
                    System.out.print("enter rental type: ");
                    movie.setMovieType(MovieTypeFactory.getMovieType(scanner.nextLine()));
                    movieService.updateMovie(movie);
                }

                case "0" -> showLegend();

                default -> System.out.println("enter valid operation number");
            }
        }
    }
    private static void showLegend() {
        System.out.println("""
                     1. list all customers
                     2. list all movies
                     3. add new customer
                     4. add new movie
                     5. find customers by name
                     6. find movies by title
                     7. add new rental to customer
                     8. get console statement
                     9. get html statement
                    10. change movie type
                     0. show legend
                """);
    }
}
