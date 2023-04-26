package patterns.task.dao;

import patterns.task.domain.Movie;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MovieDao {
    public void saveToFile(Map<String, Movie> movies) {
        try {
            FileOutputStream fos = new FileOutputStream("movies.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movies);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Movie> loadFromFile() {
        try {
            File file = new File("movies.bin");
            if (!file.exists()) {
                saveToFile(new HashMap<>());
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, Movie> movies = (Map<String, Movie>) ois.readObject();
            ois.close();
            fis.close();
            return movies;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
