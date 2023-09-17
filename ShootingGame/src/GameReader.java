import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GameReader {
    class Person {
        private String name;
        private int age;
        private String city;

        // Getter and setter methods (or you can make the fields public)

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        // Create a Gson object
        Gson gson = new Gson();

        try {
            // Create a FileReader to read the JSON file
            File file = new File("data.json");
            FileReader reader = new FileReader(file);

            // Use Gson to parse the JSON data into a Person object
            Person person = gson.fromJson(reader, Person.class);

            // Now you can access the fields of the Person object
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
