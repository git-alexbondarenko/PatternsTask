package patterns.task.dao;

import patterns.task.domain.Customer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerDao {
    public void saveToFile(Map<String, Customer> customers) {
        try {
            FileOutputStream fos = new FileOutputStream("customers.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Customer> loadFromFile() {
        try {
            File file = new File("customers.bin");
            if (!file.exists()) {
                saveToFile(new HashMap<>());
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, Customer> customers = (Map<String, Customer>) ois.readObject();
            ois.close();
            fis.close();
            return customers;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
