package patterns.task.services;

import patterns.task.dao.CustomerDao;
import patterns.task.domain.Customer;

import java.util.*;

public class CustomerService {
    private Map<String, Customer> customers = new HashMap<>();
    private final CustomerDao customerDao = new CustomerDao();

    public CustomerService() {
        load();
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(String name)  {
        Customer newCustomer = new Customer(name);
        customers.put(name, newCustomer);
        save();
    }

    public void updateCustomer(Customer updatedCustomer) {
        customers.get(updatedCustomer.getName()).setRentals(updatedCustomer.getRentals());
        save();
    }

    public void save() {
        customerDao.saveToFile(customers);
    }

    public void load() {
        customers = customerDao.loadFromFile();
    }

    public Customer getByName(String name) {
        return customers.get(name);
    }

    public void findByName(String name) {
        for (String key: customers.keySet()) {
            if (key.contains(name)) {
                System.out.println(customers.get(key));
            }
        }
    }
}
